package BOJ_1922;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int w;
	int cost;
	
	public Node(int w, int cost) {
		this.w = w;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {

	static List<Node>[] graph;
	
	static int prim(int start, int len) {
		boolean[] visit = new boolean[len + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		int total = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int v = node.w;
			int cost = node.cost;
			
			if(visit[v]) continue;
			
			visit[v] = true;
			total += cost;
			
			for(Node n : graph[v]) {
				if(!visit[n.w]) pq.add(n);
			}
		}
		
		return total; 
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		for(int n = 0; n <= N; n++) graph[n] = new ArrayList<>();
		
		for(int m = 0; m < M ; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		System.out.println(prim(1, N));
		
	}

}
