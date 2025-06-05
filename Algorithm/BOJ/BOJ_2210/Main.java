package BOJ_2210;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static String[][] board = new String[5][5];
	static Set<String> set = new HashSet<>();
	
	static void dfs(int i, int j, String route) {
		if(route.length() == 6) {
			set.add(route);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0 <= ni && ni < 5 && 0 <= nj && nj < 5) {
				dfs(ni, nj, route + board[ni][nj]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = st.nextToken();
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, board[i][j]);
			}
		}
		
		System.out.println(set.size());
		
		
	}

}
