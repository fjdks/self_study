package BOJ_15657;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nums;
	static StringBuilder sb;
	
	static void solution(int[] arr, int depth, int start, int N, int R) {
		if(depth == R) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = start; i < N; i++) {
			arr[depth] = nums[i];
			solution(arr, depth+1, i, N, R);
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
		
		sb = new StringBuilder();
		solution(new int[M], 0, 0, N, M);
		
		System.out.println(sb);
		br.close();
	}

}
