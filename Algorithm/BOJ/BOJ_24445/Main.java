package BOJ_24445;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int[] order;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 1;
		order[start] = cnt;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int next = graph.get(cur).get(i); 
				if(order[next] == 0) {
					order[next] = ++cnt;
					q.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		order = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		bfs(R);
		for (int i = 1; i < order.length; i++) {
			System.out.println(order[i]);
		}
		
	}

}
