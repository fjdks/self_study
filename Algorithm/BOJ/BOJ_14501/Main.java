package BOJ_14501;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N + 1][2]; 
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			schedule[n][0] = Integer.parseInt(st.nextToken());
			schedule[n][1] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] dp = new int[N + 2];
		int max = 0;
		for (int i = N; i > 0; i--) {
			if((i + schedule[i][0] - 1) <= N) max = Math.max(max, schedule[i][1] + dp[i + schedule[i][0]]);
			else dp[i] = 0;
			dp[i] = max;
		}
		System.out.println(max);

	}

} 
