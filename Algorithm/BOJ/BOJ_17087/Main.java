package BOJ_17087;

import java.io.*;
import java.util.*;

public class Main {
	
	static int GCD(int a, int b) {
		if(b == 0) return a;
		return GCD(b, a % b);
	}
	
	static int GCD(int[] arr) {
		int result = arr[0];
		for(int i = 1; i < arr.length; i++) {
			result = GCD(result, arr[i]);
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
		
		System.out.println(GCD(A));
		
		
	}

}
