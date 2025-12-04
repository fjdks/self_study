package BOJ_9461;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			if(N >= 6) {
				for (int i = 6; i <= N; i++) {
					if(dp[i] != 0) continue;
					dp[i] = dp[i - 5] + dp[i - 1]; 
				}
			}
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}

}
