package BOJ_10817;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] nums = new int[3];
		
		for (int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(nums);
		
		System.out.println(nums[1]);
	}

}
