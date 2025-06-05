package BOJ_14284;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] dist;
	static ArrayList<Node>[] list;
	
	static class Node implements Comparable<Node> {
		int node, weight;
		
		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node n) {
			if(this.weight > n.weight) return 1;
			return -1;
		}
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] v = new boolean[n + 1];
		q.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(v[cur.node]) continue;
			v[cur.node] = true;
			
			for (int i = 0; i < list[cur.node].size(); i++) {
				Node next = list[cur.node].get(i);
				if(dist[next.node] > dist[cur.node] + next.weight) {
					dist[next.node] = dist[cur.node] + next.weight;
					q.offer(new Node(next.node, dist[next.node]));
				}
			}
		}
		return dist[end];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, cost));
			list[end].add(new Node(start, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		System.out.println(dijkstra(s, t));
		
	}

}
