package BOJ_1449;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] tapes = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) tapes[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(tapes);
		
		int start = 0;
		int cnt = 1;
		while(start < N) {
			if(tapes[start] + L > tapes[N - 1]) break;
			for (int i = start; i < N; i++) {
				if(tapes[i] < tapes[start] + L) continue;
				else {
					start = i;
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
		
		
	}

}
