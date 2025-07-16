package BOJ_1026;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		Integer[] sorted_B = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			sorted_B[i] = B[i];
		}
		
		Arrays.sort(A);
		Arrays.sort(sorted_B, Collections.reverseOrder());
		
		boolean[] v = new boolean[N];
		int[] ans_list = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[j] && (sorted_B[i] == B[j])) {
					ans_list[j] = A[i];
					v[j] = true;
					break;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += (ans_list[i] * B[i]);
		}
		System.out.println(ans);
	}

}
