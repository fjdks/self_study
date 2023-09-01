package BOJ_16173;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] di = {0, 1};
	static int[] dj = {1, 0};
	static int[][] map;
	static boolean[][] v;
	
	static boolean bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {0, 0});
		v[0][0] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			if(map[ij[0]][ij[1]] == -1) return true;
			for (int i = 0; i < 2; i++) {
				int ni = ij[0] + di[i] * map[ij[0]][ij[1]];
				int nj = ij[1] + dj[i] * map[ij[0]][ij[1]];
				if(ni < N && nj < N && !v[ni][nj]) {
					q.offer(new int[] {ni, nj});
					v[ni][nj] = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		v = new boolean[N][N];
		
		System.out.println(bfs()? "HaruHaru" : "Hing");
	}

}
