package BOJ_10989;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		for (int i = 0; i < N; i++) {
			sb.append(nums[i]).append("\n");
		}
		
		System.out.println(sb);

	}

}
