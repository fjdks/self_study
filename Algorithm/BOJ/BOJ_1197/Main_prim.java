package BOJ_1197;

import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge>{
	int w;
	int cost;
	
	public Edge(int end, int weight) {
		this.w = end;
		this.cost = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}


public class Main_prim {

	static List<Edge>[] graph;
	
	static int prim(int start, int n) {
		boolean[] visit = new boolean[n + 1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		
		int total = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.w;
			int cost = edge.cost;
			
			if(visit[v]) continue;
			
			visit[v] = true;
			total += cost;
			
			for(Edge e: graph[v]) {
				if(!visit[e.w]) pq.add(e);
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V + 1];
		for(int v = 0; v <= V; v++) graph[v] = new ArrayList<>();
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Edge(B, C));
			graph[B].add(new Edge(A, C));
		}
		
		
		System.out.println(prim(1, V));
		
		
	}

}
