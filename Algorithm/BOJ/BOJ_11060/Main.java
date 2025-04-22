package BOJ_11060;

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] miro;
	static boolean[] v;
	
	static int bfs(int start_idx) {
		Queue<int[]> q = new LinkedList<int[]>();
		int cnt = -1;
		q.add(new int[] {start_idx, 0});
		v[start_idx] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == N - 1) {
				cnt = cur[1];
			} 
			for (int i = 0; i <= miro[cur[0]]; i++) {
				int next = cur[0] + i;
				if(next < N && !v[next]) {
					q.add(new int[] {next, cur[1] + 1});
					v[next] = true;
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		miro = new int[N];
		v = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			miro[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bfs(0));
	}

}
