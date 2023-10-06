package BOJ_15683;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans;
	static int[][] office;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Node> cctv;
	
	static int[][][] mode = {{{0}}, {{0}, {1}, {2}, {3}}, {{2, 3}, {0, 1}},
			{{0, 3}, {1, 3}, {1, 2}, {0, 2}},
			{{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
			{{0, 1, 2, 3}}};
	
	static class Node {
		int x, y, type;
		public Node(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	static void comb(int depth, int r, int[][] office) {
		if(depth == r) {
			int cnt = check(office);
			ans = Math.min(ans, cnt);
			return;
		}
		int cctv_type = cctv.get(depth).type;
		int x = cctv.get(depth).x;
		int y = cctv.get(depth).y;
		
		for (int i = 0; i < mode[cctv_type].length; i++) {
			int[][] copy_office = new int[N][M];
			for (int k = 0; k < N; k++) {
				copy_office[k] = office[k].clone();
			}
			
			for (int j = 0; j < mode[cctv_type][i].length; j++) {
				int dir = mode[cctv_type][i][j];
				
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				while(true) {
					if(nx < 0 || N <= nx || ny < 0 || M <= ny) break;
					if(office[nx][ny] == 6) break;
					copy_office[nx][ny] = -1;
					nx += dx[dir];
					ny += dy[dir];
				}
			}
			comb(depth + 1, r, copy_office);
		}
		
	}
	
	static int check(int[][] office) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(office[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int zero_cnt = 0;
		cctv = new ArrayList<>();
		office = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(1 <= office[i][j] && office[i][j] <= 5) cctv.add(new Node(i, j, office[i][j]));
				else if(office[i][j] == 0) zero_cnt++;
			}
		}
		ans = zero_cnt;
		comb(0, cctv.size(), office);
		System.out.println(ans);
	}
}
