package BOJ_13565;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static boolean flag;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] fiber;
	static boolean[][] v;
	static ArrayList<Integer> conductor;
	
	static void dfs(int x, int y) {
		if(x == M - 1 && fiber[x][y] == 0) flag = true;
		
		for (int d = 0; d < 4; d++) {
			int ni = x + di[d];
			int nj = y + dj[d];
			if(0 <= ni && ni < M && 0 <= nj && nj < N && !v[ni][nj] && fiber[ni][nj] != 1) {
				v[ni][nj] = true;
				dfs(ni, nj);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		fiber = new int[M][N];
		v = new boolean[M][N];
		conductor = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			for (int j = 0; j < N;j++) {
				int cur = line.charAt(j) - '0';
				fiber[i][j] = cur;
				if(i == 0 && cur == 0) conductor.add(j);
			}
		}
		
		for (int i = 0; i < conductor.size(); i++) {
			int cur = conductor.get(i);
			v[0][cur] = true;
			dfs(0, cur);
			if(flag) break;
		}
		
		System.out.println(flag ? "YES" : "NO");
		
		
	}

}
