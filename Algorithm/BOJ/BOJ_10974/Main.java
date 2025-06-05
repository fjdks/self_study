package BOJ_10974;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] nums;
	static boolean[] v;
	static StringBuilder sb;
	
	static void perm(int[] arr, int depth) {
		if(depth == N) {
			sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(' ');
			}
			System.out.println(sb);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				arr[depth] = nums[i];
				perm(arr, depth + 1);
				v[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		for (int i = 0; i < N; i++) nums[i] = i + 1;
		
		v = new boolean[N];
		
		perm(new int[N], 0);
		
	}
}
