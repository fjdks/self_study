package BOJ_11399;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] order;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		order = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) order[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(order);
		
		int len = N;
		int sum = 0;
		for (int i = 0; i < N; i++) sum += order[i] * len--;
		System.out.println(sum);
	}

}
