package BOJ_2644;

import java.io.*;
import java.util.*;

public class Main {
	
	static int res = -1;
	static ArrayList<Integer>[] relation;
	static boolean[] v;
	
	static void dfs(int start, int end, int cnt) {
		if(start == end) {
			res = cnt;
			return;
		}
		
		v[start] = true;
		for (int i = 0; i < relation[start].size(); i++) {
			int next = relation[start].get(i);
			if(!v[next]) dfs(next, end, cnt + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		relation = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			relation[i] = new ArrayList<Integer>();
		}
		v = new boolean[n + 1];
		
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x].add(y);
			relation[y].add(x);
		}
		 dfs(p1, p2, 0);
		 System.out.println(res);
		
	}

}
