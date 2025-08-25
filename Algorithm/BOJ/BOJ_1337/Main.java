package BOJ_1337;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(nums);

		int cnt = 5;
		for (int i = 0; i < N; i++) {
			int cur = nums[i];
			int max = cur + 5;
			int in_range_cnt = 1;
			for (int j = i + 1; j < N; j++) {
				if(nums[j] < max) in_range_cnt++; 
				else break;
			}
			cnt = Math.min(cnt, 5 - in_range_cnt);
		}
		System.out.println(cnt);
		
	}

}
