package BOJ_15654;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] nums;
	static boolean[] v;
	static StringBuilder sb;
	
	static void perm(int[] arr, int N, int M, int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				arr[depth] = nums[i];
				perm(arr, N, M, depth + 1);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		v = new boolean[N];
		sb = new StringBuilder();
		perm(new int[M], N, M, 0);
		
		System.out.println(sb);
		br.close();
	}
}
