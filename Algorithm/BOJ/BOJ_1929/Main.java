package BOJ_1929;

import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb ;
	
	static boolean isPrime(int X) {
		if(X == 1) return false;
		int root_X = (int)Math.sqrt(X);
		for (int i = 2; i <= root_X; i++) {
			if(X % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static void eratos(int M, int N) {
		for (int i = M; i <= N; i++) {
			if(isPrime(i)) {
				sb.append(i).append('\n');
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		eratos(M, N);
		System.out.println(sb);
	}

}
