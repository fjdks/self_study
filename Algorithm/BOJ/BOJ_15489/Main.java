package BOJ_15489;

import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, W;
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		dp[0][0] = 1;
		for (int i = 1; i < (R - 1) + W; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) dp[i][j] = 1;
				else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		int row = 0;
		int sum = 0;
		for (int i = R - 1; i < (R - 1) + W; i++) {
			for (int j = C - 1; j <= (C - 1) + row; j++) {
				System.out.println(dp[i][j]);
				sum += dp[i][j];
			}
			row += 1;
		}
		System.out.println(sum);
		
//		for (int i = 0; i < (R - 1) + W; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

}
