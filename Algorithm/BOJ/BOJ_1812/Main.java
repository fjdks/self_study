package BOJ_1812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] ans = new int[N];
		
		for (int i = 0; i < N; i++)	arr[i] = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if((i % 2) == 0) sum += arr[i];
			else sum -= arr[i];
		}
		
		ans[0] = sum/2;
		
		for (int i = 1; i < N; i++) ans[i] = arr[i - 1] - ans[i - 1];
		
		for (int i = 0; i < N; i++) {
			System.out.println(ans[i]);
		}
	}

}
