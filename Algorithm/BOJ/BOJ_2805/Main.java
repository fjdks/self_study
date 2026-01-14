package BOJ_2805;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] trees;
	
	static int binary_search(int L, int R) {
		int mid = 0;
		long sum = 0;
		while(L < R) {
			sum = 0;
			mid = (L + R) / 2;
			for (int i = N - 1; i >= 0; i--) {
				if((trees[i] - mid) > 0) sum += (trees[i] - mid);
				else break;
			}
			if(sum < M) R = mid;
			else L = mid + 1;
		}
		return L - 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(trees);
		
		System.out.println(binary_search(0, trees[N - 1]));
		
		
	}

}
