package BOJ_3036;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int GCD(int a, int b) {
		if(b == 0) return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] circles = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) circles[i] = Integer.parseInt(st.nextToken());
		
		int std = circles[0];
		for (int i = 1; i < N; i++) {
			int gcd = GCD(std, circles[i]);
			System.out.println((std / gcd) + "/" + (circles[i] / gcd));
		}
	}

}
