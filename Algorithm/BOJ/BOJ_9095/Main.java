package BOJ_9095;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[11];

			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			if(N >= 4) {
				for (int i = 4; i <= N; i++) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}

}
