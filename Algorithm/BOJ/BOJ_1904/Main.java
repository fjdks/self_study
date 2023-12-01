package BOJ_1904;

import java.io.*;

public class Main {
	
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < N + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}
		System.out.println(dp[N]);
		
	}

}
