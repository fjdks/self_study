package BOJ_2090;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int gcd(int a, int b) {
		if(b  == 0) return a;
		return gcd(b, a % b);
	}
	
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
	static int lcm(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = lcm(result, arr[i]);
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int lcm = lcm(A);
		
		int numerator = 0;
		for (int i = 0; i < A.length; i++) numerator += (lcm / A[i]);
		
		int gcd = gcd(numerator, lcm);
		
		System.out.println((lcm / gcd) + "/" + (numerator / gcd));
		
	}

}
