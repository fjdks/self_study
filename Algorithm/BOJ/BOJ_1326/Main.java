package BOJ_1326;

import java.io.*;
import java.util.*;

public class Main {

	static int N, a, b;
	static int[] stones;
	
	static int bfs(int start, int end) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] v = new boolean[N + 1];
		
		q.add(new int[] {start, 0});
		v[start] = true;
		int cnt = 0;
		boolean flag = false;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cur_pos = cur[0];
			int cur_cnt = cur[1];
			
			if(cur_pos == b) {
				cnt = cur_cnt;
				flag = true;
				break;
			}
				
			for (int i = 1; i <= N; i++) {
				int next = cur_pos + (stones[cur_pos] * i);
				if(next <= N && !v[next]) {
					q.add(new int[] {next, cur_cnt + 1});
					v[next] = true;
				}
				int m_next = cur_pos - (stones[cur_pos] * i);
				if(m_next > 0 && !v[m_next]) {
					q.add(new int[] {m_next, cur_cnt + 1});
					v[m_next] = true;
				}
			}
			
		}
		return flag ? cnt : -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		stones = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			stones[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		if(a == b) System.out.println(0);
		else System.out.println(bfs(a, b));
	}
}
