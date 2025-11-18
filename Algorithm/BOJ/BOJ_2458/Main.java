package BOJ_2458;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int GCD(int a, int b) {
		if(b == 0) return a;
		return GCD(b, a % b);
	}
	
	static int GCD(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) result = GCD(result, arr[i]);
		return result;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] trees = new int[N];
		for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(br.readLine());
		
		int[] gap = new int[N - 1];
		for (int i = 0; i < gap.length; i++) gap[i] = trees[i + 1] - trees[i];
		
		System.out.println((((trees[N - 1] - trees[0]) / GCD(gap)) + 1) - N);
		
	}

}
