package BOJ_15666;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] nums;
	static LinkedHashSet<String> ans;
	static StringBuilder sb;
	
	static void solution(int[] arr, int depth, int start) {
		if(depth == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			ans.add(sb.toString());
			return;
		}
		for (int i = start; i < N; i++) {
			arr[depth] = nums[i];
			solution(arr, depth + 1, i);
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
		
		ans = new LinkedHashSet<>();
		Arrays.sort(nums);
		
		solution(new int[M], 0, 0);
		for(String a:ans)System.out.println(a);
		
		br.close();
	}

}
