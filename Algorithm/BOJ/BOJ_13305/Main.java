package BOJ_13305;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] dist = new long[N - 1];
		long[] price = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) dist[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) price[i] = Integer.parseInt(st.nextToken());
		price[N - 1] = Integer.MAX_VALUE;
		
		long sum = 0;
		long min = price[0];
		for (int i = 0; i < N - 1; i++) {
			if(min > price[i]) min = price[i];
			sum += min + dist[i];
		}
		
		System.out.println(sum);
		
	}

}
