package BOJ_1388;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static boolean[][] v;
	static char[][] room;
	
	static void dfs(int i, int j, boolean row) {
		v[i][j] = true;
		if(row) {
			j++;
			if(j<M && room[i][j] == '-') dfs(i, j, true);
		}
		else {
			i++;
			if(i<N && room[i][j] != '-') dfs(i, j, false);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		room = new char[N][M]; 
		v = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			for (int m = 0; m < M; m++) {
				room[n][m] = line.charAt(m);
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(v[i][j]) continue;
				if(room[i][j] == '-') dfs(i, j, true);
				else dfs(i, j, false);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
