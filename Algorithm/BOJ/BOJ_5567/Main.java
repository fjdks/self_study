package BOJ_5567;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static boolean[] v;
	static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();
	
	static void bfs(int D, int start) {
		if(D >= 2) return;
		
		for(int i : friends.get(start)) {
			v[i] = true;
			bfs(D + 1, i);
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		v = new boolean[n + 1];
		
		for (int i = 0; i < n + 1; i++) friends.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends.get(a).add(b);
			friends.get(b).add(a);
		}
		
		v[1] = true;
		bfs(0, 1);
		int cnt = -1;
		for (int i = 0; i < v.length; i++) {
			if(v[i]) cnt++;
		}
		System.out.println(cnt);
		
		
	}

}
