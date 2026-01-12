package BOJ_7795;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] A = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) A[n] = Integer.parseInt(st.nextToken());
			Arrays.sort(A);
			
			int[] B = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) B[m] = Integer.parseInt(st.nextToken());
			Arrays.sort(B);
			
			int cnt = 0;
			for (int n = 0; n < N; n++) {
				int cur = A[n];
				int l = 0;
				int r = M;
				while(l < r) {
					int mid = (l + r) / 2;
					if(B[mid] < cur) l = mid + 1;
					else r = mid;
				}
				cnt += l;
			}
			
			System.out.println(cnt);
			
			
		}
	}

}
