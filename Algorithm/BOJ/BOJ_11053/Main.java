package BOJ_11053;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] A, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];
		int max_len = 1;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(A[i] > A[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
				max_len = Math.max(max_len, dp[i]);
			}
		}
		
		
		System.out.println(max_len);
	}

}
