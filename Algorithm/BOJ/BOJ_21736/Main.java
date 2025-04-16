package BOJ_21736;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M, cnt;
	static int[] di = new int[] {-1, 1, 0, 0};
	static int[] dj = new int[] {0, 0, -1, 1};
	static char[][] campus;
	static boolean[][] v;
	
	static void dfs(int cur_i, int cur_j) {
		if(campus[cur_i][cur_j] == 'P') {
			cnt++;
		}
		for (int d = 0; d < 4; d++) {
			int ni = cur_i + di[d];
			int nj = cur_j + dj[d];
			if(0 <= ni && ni < N && 0 <= nj && nj < M && campus[ni][nj] != 'X' && !v[ni][nj]) {
				v[ni][nj] = true;
				dfs(ni, nj);
			}
		}
	}
	
	static void bfs(int cur_i, int cur_j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {cur_i, cur_j});
		v[cur_i][cur_j] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			if(campus[i][j] == 'P') cnt++;
			
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0 <= ni && ni < N && 0 <= nj && nj < M && campus[ni][nj] != 'X' && !v[ni][nj]) {
					q.add(new int[] {ni, nj});
					v[ni][nj] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		campus = new char[N][M];
		v = new boolean[N][M];
		
		int[] I_pos = new int[2];
		
		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			for (int m = 0; m < M; m++) {
				char c = line.charAt(m);
				if(c == 'I') I_pos = new int[] {n, m};
				campus[n][m] = c;
			}
		}
		
		cnt = 0;
//		dfs(I_pos[0], I_pos[1]);
		bfs(I_pos[0], I_pos[1]);
		System.out.println(cnt == 0 ? "TT" : cnt);
		
	}

}
