package BOJ_2740;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] B = new int[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int n = 0; n < N; n++) {
			for (int k = 0; k < K; k++) {
				int cur = 0;
				for (int m = 0; m < M; m++) {
					cur += (A[n][m] * B[m][k]);
				}
				sb.append(cur).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
