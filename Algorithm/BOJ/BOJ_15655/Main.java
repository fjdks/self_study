package BOJ_15655;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static boolean[] v;
	static int[] nums;
	static StringBuilder sb;
	
	static void sub(int[] arr, int start, int depth) {
		if(depth == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			System.out.println(sb);
			return;
		}
		for (int i = start; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				arr[depth] = nums[i];
				sub(arr, i + 1, depth + 1);
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
		v = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		sub(new int[M], 0, 0);
		
	}

}
