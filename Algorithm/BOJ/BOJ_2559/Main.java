package BOJ_2559;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] temps;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		temps = new int[N];
		int cur = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temps[i] = Integer.parseInt(st.nextToken());
			if(i < K) cur += temps[i];
		}
		int max = cur;
		for (int i = 1; i < N - K + 1; i++) {
			cur = cur - temps[i - 1] + temps[i + K - 1];
			max = Math.max(max, cur);
		}
		System.out.println(max);
		
	}

}
