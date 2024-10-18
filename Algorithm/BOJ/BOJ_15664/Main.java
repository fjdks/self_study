package BOJ_15664;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] nums;
	static boolean[] v;
	static LinkedHashSet<String> set;
	static StringBuilder sb;

	static void comb(int[] arr, int start, int depth) {
		if(depth == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			set.add(sb.toString());
			return;
		}
		for (int i = start; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				arr[depth] = nums[i];
				comb(arr, i + 1, depth + 1);
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
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		
		v = new boolean[N];
		
		set = new LinkedHashSet<>();
		
		comb(new int[M], 0, 0);
		
		set.forEach(each -> System.out.println(each));
//		for(String each : set) {
//			System.out.println(each);
//		}
		
	}

}
