package BOJ_13549;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static boolean[] v = new boolean[100001];
	
	static int move() {
		while(true) {
			int[] cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			if(cur[0] == K) {
				return cur[1];
			}
			else v[cur[0]] = true;
			
			if((cur[0] * 2) <= 100000 && !v[cur[0]  * 2]) q.add(new int[] {cur[0]  * 2, cur[1]});
			if((cur[0] - 1) >= 0 && !v[cur[0] - 1]) q.add(new int[] {cur[0] - 1, cur[1] + 1});
			if((cur[0] + 1) <= 100000 && !v[cur[0] + 1]) q.add(new int[] {cur[0] + 1, cur[1] + 1});
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q.add(new int[] {N, 0});
		
		System.out.println(move());
		
	}

}
