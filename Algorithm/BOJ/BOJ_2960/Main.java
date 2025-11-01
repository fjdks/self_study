package BOJ_2960;

import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		v = new boolean[N + 1];
		
		int cnt = 0;
		loop:while(true) {
			for (int i = 2; i < N + 1; i++) {
				if(!v[i]) {
					for (int j = i; j < N + 1; j += i) {
						if(!v[j]) {
							v[j] = true;
							cnt++;
							if(cnt == K) {
								System.out.println(j);
								break loop;
							}
						}
					}
				}
			}
		}
	}

}
