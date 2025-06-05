package BOJ_2407;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	static BigInteger dpcomb[][];
	
	static void dp(int N, int M) {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					dpcomb[i][j] = new BigInteger("1");
				} else {
					dpcomb[i][j] = dpcomb[i - 1][j - 1].add(dpcomb[i - 1][j]);
				}
				
			}
			
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dpcomb = new BigInteger[1001][1001];
		
		dp(N,M);
		System.out.println(dpcomb[N][M]);
	}

}
