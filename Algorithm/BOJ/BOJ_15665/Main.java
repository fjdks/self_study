package BOJ_15665;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] nums;
	static StringBuilder sb;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	static void re_perm(int[] arr, int depth) {
		if(depth == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[depth] = nums[i];
			re_perm(arr, depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		
		re_perm(new int[N], 0);
		
		set.forEach(each -> System.out.println(each));
	}

}
