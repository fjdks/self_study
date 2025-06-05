package BOJ_2512;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, sum, left, right, mid;
	static int[] req;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		req = new int[N];
		
		left = 1;
		right =1000000000;
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			req[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, req[i]);
			sum += req[i];
		}
		
		M = Integer.parseInt(br.readLine());
		right = Math.min(M, max);
		if(sum <= M) System.out.println(right);
		else {
			int ans = 0;
			while(true) {
				mid = (left + right) / 2;
				if(ans == mid) break;
				sum = 0;
				for (int i = 0; i < N; i++) sum += Math.min(req[i], mid);
				if(sum == M) break;
				else if(sum < M) {
					left = mid;
				} else if (sum > M) {
					right = mid;
				}
				ans = mid;
			}
			System.out.println(mid);
		}
	}

}

/*
5
100 100 100 100 100
10
*/ 