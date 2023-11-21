package BOJ_14938;

import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 987654321;
	static int n, m, r;
	static int[] items;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) continue;
				matrix[i][j] = INF;
			}
		}
		
		items = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			matrix[start][end] = weight;
			matrix[end][start] = weight;
			
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
		
		int res = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			cnt = 0;
			for (int j = 0; j < n; j++) {
				if(matrix[i][j] <= m) {
					cnt += items[j];
				}
			}
			res = Math.max(res, cnt);
		}
		System.out.println(res);
		
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
	}

}
