package BOJ_31575;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] di = new int[] {0, 1};
	static int[] dj = new int[] {1, 0};
	
	static boolean dfs(int[][] c, boolean[][] v, int x, int y) {
		if(x == M - 1 && y == N - 1) return true;
		
		if(x < 0 || x >= M || y < 0 || y >= N || c[x][y] == 0 || v[x][y]) return false;
		v[x][y] = true;
		
		if(dfs(c, v, x + 1, y)) return true;
		if(dfs(c, v, x, y + 1)) return true;
		
		return false;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] city = new int[M][N];
		boolean[][] visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(dfs(city, visited, 0, 0)) System.out.println("Yes");
		else System.out.println("No");
		
		
	}

}
