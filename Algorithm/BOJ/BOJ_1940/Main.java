package BOJ_1940;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, cnt;
	static int[] mat;
	
	static void comb(int R, int D, int start, int[] arr) {
		if(D == R) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			if(sum == M) cnt++;
			return;
		}
		for (int i = start; i < N; i++) {
			arr[D] = mat[i];
			comb(R, D + 1, i + 1, arr);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		mat = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) mat[i] = Integer.parseInt(st.nextToken());
		
		comb(2, 0, 0, new int[2]);
		System.out.println(cnt);
	}
}
