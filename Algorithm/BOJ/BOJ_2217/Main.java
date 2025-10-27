package BOJ_2217;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] rope = new int[N];
		for (int i = 0; i < N; i++) rope[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(rope);
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = N - i; j > 0; j--) {
				max = Math.max(max, rope[i] * j);
			}
		}
		System.out.println(max);
	}

}
