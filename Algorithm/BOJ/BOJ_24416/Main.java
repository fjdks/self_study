package BOJ_24416;

import java.io.*;

public class Main {
	
	static int code1 = 0;
	static int code2 = 0;
	static int[] dp;

	static int fibo1(int n) {
		if(n == 1 || n == 2) {
			code1++;
			return 1;
		} 
		return fibo1(n - 1) + fibo1(n - 2);
	}
	
	static void fibo2(int n) {
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
			code2++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		fibo1(n);
		fibo2(n);
		System.out.println(code1 + " " + code2);
	}

}
