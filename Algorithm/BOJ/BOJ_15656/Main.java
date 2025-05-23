package BOJ_15656;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	
	static void rePerm(int[] arr, int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[depth] = nums[i];
			rePerm(arr, depth + 1);
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
		
		rePerm(new int[M], 0);
		System.out.println(sb);
	}

}
