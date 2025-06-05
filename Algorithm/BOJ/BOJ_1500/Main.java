package BOJ_1500;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int div = S / K;
		int mod = S % K;
		long max = 1;
		for (int i=1; i<=K; i++) {
			if(i<=mod) max *= (div+1);
			else max *= div;
		}
		System.out.println(max);
	}

}
