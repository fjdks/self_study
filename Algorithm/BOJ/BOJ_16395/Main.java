package BOJ_16395;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dp = new int[31][31];
	
	static void pascal() {
		dp[0][0] = 1;
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) dp[i][j] = 1;
				else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		pascal();
		
		System.out.println(dp[n - 1][k - 1]);
	}

}
