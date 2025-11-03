package BOJ_9613;

import java.io.*;
import java.util.*;

public class Main {

	static long gcd;
	static int[] nums;
	
	static void comb(int D, int R, int start, boolean[] v, int[] arr) {
		if(R == D) {
			gcd += get_gcd(arr[0], arr[1]);
			return;
		}
		for (int i = start; i < nums.length; i++) {
			v[i] = true;
			arr[D] = nums[i];
			comb(D + 1, R, i + 1, v, arr);
			v[i] = false;
			
		}
	}
	
	static int get_gcd(int a, int b) {
		if(b == 0) return a;
		return get_gcd(b, a % b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int len = Integer.parseInt(st.nextToken());
			
			nums = new int[len];
			for (int l = 0; l < len; l++) nums[l] = Integer.parseInt(st.nextToken());
			
			gcd = 0;
			comb(0, 2, 0, new boolean[len], new int[2]);
		
			System.out.println(gcd);
			
		}
	}

}
