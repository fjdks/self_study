package BOJ_26169;

import java.io.*;
import java.util.*;

public class Main {
	
	static int r, c;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] board = new int[5][5];
	static boolean[][] v = new boolean[5][5];
	
	static int dfs(int i, int j, int cnt, int depth) {
		v[i][j] = true;
		if(board[i][j] == 1) cnt++;
		if(depth > 3 && cnt < 2) {
			v[i][j] = false;
			return 0;
		}
		if(depth <= 3 && cnt >= 2) {
			return 1;
		}
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0 <= ni && ni < 5 && 0 <= nj && nj < 5 && !v[ni][nj] && board[ni][nj] != -1) {
				if(dfs(ni, nj, cnt, depth + 1) == 1) return 1;
			}
		}
		v[i][j] = false;
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		
		System.out.println(dfs(r, c, 0, 0));
		
	}

}
