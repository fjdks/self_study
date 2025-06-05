package BOJ_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] lans = new int[K];
		
		long min = 0;
		long max = 0;
		long mid = 0;
		for (int i = 0; i < K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			max = Math.max(lans[i], max);
		}
		
		max++;
		while(min < max) {
			mid = (max + min) / 2;
			
			long cnt = 0;
			
			for (int i = 0; i < K; i++) cnt += (lans[i] / mid);
			
			if(cnt < N) max = mid;
			else min = mid + 1;
		}
		
		System.out.println(min - 1);
		
	}

}

