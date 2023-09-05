package BOJ_25418;

import java.io.*;
import java.util.*;

public class Main {
	
	static int A, K, cnt;
	static boolean[] v;
	
	static void bfs(int A, int K) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {A, 0});
		v[A] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == K) {
				System.out.println(cur[1]);
				return;
			} if(cur[0] * 2 <= K) {
				q.add(new int[] {cur[0] * 2, cur[1] + 1});
				v[cur[0] * 2] = true;
			} if(!v[cur[0] + 1]) q.add(new int[] {cur[0] + 1, cur[1] + 1});
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		v = new boolean[K + 1];
		if(A == K) System.out.println(0);
		else bfs(A, K);
	}

}
