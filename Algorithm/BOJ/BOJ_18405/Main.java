package BOJ_18405;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[][] plate;
	static boolean[][] v;
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static void bfs(int virus_num) {
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(plate[i][j] == virus_num) arr.add(new int[] {i, j});
			}
		}
		if(arr.isEmpty()) return;
		
		v[arr.get(0)[0]][arr.get(0)[1]] = true;
		for (int i = 0; i < arr.size(); i++) {
			int[] cur = arr.get(i);
			for (int d = 0; d < 4; d++) {
				int ni = cur[0] + di[d];
				int nj = cur[1] + dj[d];
				if(0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && plate[ni][nj] == 0) {
					plate[ni][nj] = virus_num;
					v[ni][nj] = true;
				}
			}
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		plate = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		v = new boolean[N][N];
		
		loop:for (int i = 0; i < S; i++) {
			for (int j = 1; j <= K; j++) {
				bfs(j);
				
				if(plate[X-1][Y-1] != 0) break loop;
			}
		}
		System.out.println(plate[X - 1][Y - 1]);
		
	}

}
