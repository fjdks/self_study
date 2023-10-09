package BOJ_16943;

import java.io.*;
import java.util.*;

public class Main {
	
	static int B, max;
	static String A;
	static boolean[] v;
	static StringBuilder res = new StringBuilder();
	static int[] arr;
	
	static void perm(int depth, int R) {
		if(depth == R) {
			res = new StringBuilder();
			for (int i = 0; i < arr.length; i++) res.append(arr[i]);
			int temp = Integer.parseInt(res.toString());
			if(temp < B) {
				max = Math.max(max, temp);
			}
			return;
		}
		for (int i = 0; i < A.length(); i++) {
			if(depth == 0 && (A.charAt(i) == '0')) continue;
			if(!v[i]) {
				v[i] = true;
				arr[depth] = A.charAt(i) - '0';
				perm(depth + 1, R);
				v[i] = false;
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		
		v = new boolean[A.length()];
		max = -1;
		
		arr = new int[A.length()];
		perm(0, A.length());
		System.out.println(max);
	}

}
