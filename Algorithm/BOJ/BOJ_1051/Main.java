package BOJ_1051;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, cur;
	static int[][] square;
	
	static int get_square_area(int x, int y) {
		int len = 1;
		int res = 1;
		
		for (int i = x; i < N; i++) {
			if(cur == square[i][y]) {
				if((y + len - 1) < M && cur == square[i][y + len - 1] && cur == square[x][y + len - 1]) {
					res = len * len;
				}
			}
			len++;
		}
		
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		square = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				square[i][j] = line.charAt(j) - '0';
			}
		}
		
		int res = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cur = square[i][j];
				
				res = Math.max(get_square_area(i, j) , res);
			}
		}
		
		System.out.println(res);
	}
}
