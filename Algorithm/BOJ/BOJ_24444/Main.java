package BOJ_24444;

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
	static int[] visited;
	
	static void BFS(int r) {
		Queue<Integer> pq = new LinkedList<>();
		int cnt = 1;
		
		pq.add(r);
		visited[r] = cnt++;
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			for (int i = 0; i < nodes.get(cur).size(); i++) {
				int next = nodes.get(cur).get(i);
				
				if(visited[next] != 0) continue;
				
				pq.add(next);
				visited[next] = cnt++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visited = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			nodes.add(new ArrayList<>());
		}
		
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			nodes.get(u).add(v);
			nodes.get(v).add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(nodes.get(i));
		}
		
		BFS(R);
		
		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}
	}

}
