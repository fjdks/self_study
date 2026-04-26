package BOJ_6603;

import java.io.*;
import java.util.*;

public class Main {
	
	static int K;
	static int[] S, sel;
	
	static void Combination(int idx, int start) {
		if(idx == 6) {
			Arrays.sort(sel);
			for(int i = 0; i < 6; i++) System.out.print(sel[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = start; i < K; i++) {
			sel[idx] = S[i];
			Combination(idx + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			
			sel = new int[6];
			S = new int[K];
			for(int k = 0; k < K; k++) S[k] = Integer.parseInt(st.nextToken());
			
			Combination(0, 0);
			System.out.println();
			
		}
	}

}
