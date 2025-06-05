package BOJ_1010;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, res;
	static boolean[] v;
	static int[][] dp = new int[31][31];
	
	static int Comb(int n, int r) {
		if(dp[n][r] > 0) return dp[n][r];
		else if(n == r || r == 0) return dp[n][r] = 1;
		else {
			return dp[n][r] = Comb(n - 1, r - 1) + Comb(n - 1, r);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			v = new boolean[M];
			res = 0;
			
			System.out.println(Comb(M, N));
		}
	}

}
