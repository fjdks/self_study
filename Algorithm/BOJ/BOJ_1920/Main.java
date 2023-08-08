package BOJ_1920;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[] v;
	static int[] nums;
	
	static int search(int X) {
		int left = 0;
		int right = N - 1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(nums[mid] > X) {
				right = mid - 1;
			} else if(nums[mid] < X) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if(search(Integer.parseInt(st.nextToken())) >= 0) System.out.println(1);
			else System.out.println(0);
		}
	}

}
