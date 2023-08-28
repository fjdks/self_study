package BOJ_2167;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] mat_sum;
	static int[][] matrix;
	
	static int getSum(int i, int j, int x, int y) {
		int sum = 0;
		
		for (int rows = i; rows <= x; rows++) {
			sum += mat_sum[rows];
			for (int col_left = 0; col_left < j; col_left++) {
				sum -= matrix[rows][col_left];
			}
			for (int col_right = y + 1; col_right < M; col_right++) {
				sum -= matrix[rows][col_right];
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][M];
		mat_sum = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				matrix[i][j] = cur;
				sum += cur;
			}
			mat_sum[i] = sum;
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			System.out.println(getSum(i, j, x, y));
		}
		
		
		
	}

}
