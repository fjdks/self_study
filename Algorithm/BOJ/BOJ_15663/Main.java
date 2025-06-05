package BOJ_15663;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] nums;
	static boolean[] v;
	static LinkedHashSet<String> ans;
	
	static void Perm(int[] arr, int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			ans.add(sb.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				arr[depth] = nums[i];
				Perm(arr, depth + 1);
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
		
		ans = new LinkedHashSet<>();
		Perm(new int[M], 0);
		
		for(String a:ans)System.out.println(a);
		
		br.close();
	}
}
