package BOJ_18110;

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int trim = (int) Math.round(n * 0.15);
		
		int low = 0;
		for (int i = 0; i < trim; i++) {
			low += arr[i];
		}
		
		int high = 0;
		for (int i = n - trim; i < n; i++) {
			high += arr[i];
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		int ans = (int)Math.round((double)(sum - low - high) / (double)(n - trim * 2));
		System.out.println(ans);
		
	}

}
