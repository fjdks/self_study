package BOJ_1504;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, E;
	static int[] dist;
	static boolean[] v;
	static ArrayList<Node>[] list;
	static final int INF = 200000000;
	
	static class Node implements Comparable<Node> {
		int node, weight;
		
		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			if(this.weight - o.weight > 0) return 1;
			return -1;
		}
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		
		q.add(new Node(start, 0));
		dist[start] = 0;
		v = new boolean[N + 1];
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(!v[cur.node]) v[cur.node] = true;
			for (int i = 0; i < list[cur.node].size(); i++) {
				Node next = list[cur.node].get(i);
				if(!v[next.node] && dist[next.node] > dist[cur.node] + next.weight) {
					dist[next.node] = dist[cur.node] + next.weight;
					q.add(new Node(next.node, dist[next.node]));
				}
			}
		}
		return dist[end];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		v = new boolean[N + 1];
		
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		if(res1 >= INF && res2 >= INF) System.out.println(-1);
		else System.out.println(Math.min(res1, res2));
		
	}

}
