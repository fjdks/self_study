package BOJ_11866;

import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		v = new boolean[N];
		
		int cur = K - 1;
		int cnt = 0;
		while(cnt < N - 1) {
			v[cur] = true;
			sb.append(cur + 1).append(", ");
			int tmp = 0;
			while(tmp < K) {
				if(v[(cur + 1) % N]) cur = (cur + 1) % N;
				else {
					tmp += 1;
					cur = (cur + 1) % N;
				}
			}
			cnt++;
//			System.out.println(Arrays.toString(v));
		}
//		System.out.println("---");
//		System.out.println(cur);
		sb.append(cur + 1).append('>');
//		System.out.println(Arrays.toString(v));
		System.out.println(sb);
	}

}
