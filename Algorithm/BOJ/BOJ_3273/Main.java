package BOJ_3273;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int cnt = 0;
		int left = 0;
		int right = n - 1;
		while(left < right) {
			if((arr[left] + arr[right]) == x) {
				cnt++;
				left++;
				right--;
			} else if((arr[left] + arr[right]) < x) left++;
			else right--;
		}
		System.out.println(cnt);
	}

}
