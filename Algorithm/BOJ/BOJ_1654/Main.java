package BOJ_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] lans = new int[K];
		int len = 0; 
		for (int i = 0; i < K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			len = Math.max(lans[i], len);
		}
		
		int pieces = 0;
		while(true) {
			for (int i = 0; i < K; i++) {
				pieces += (lans[i] / len);
			}
			if(pieces >= N) break;
			else {
				pieces = 0;
				len--;
			}
		}
		
		System.out.println(len);
		
	}

}

