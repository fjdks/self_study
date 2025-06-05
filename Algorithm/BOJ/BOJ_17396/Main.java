package BOJ_17396;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static long[] dist;
	static boolean[] sight;
	static ArrayList<Node>[] list;
	
	static class Node implements Comparable<Node>{
		int node;
		long weight;
		
		public Node(int node, long weight) {
			this.node = node;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node n) {
			if(this.weight - n.weight > 0) return 1;
			else return -1;
		}
	}

	static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] v = new boolean[N];
		q.offer(new Node(0, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(v[cur.node]) continue;
			v[cur.node] = true;
			
			for (int i = 0; i < list[cur.node].size(); i++) {
				Node next = list[cur.node].get(i);
				if(next.node != N - 1 && sight[next.node]) continue;
				if(dist[next.node] > dist[cur.node] + next.weight) {
					dist[next.node] = dist[cur.node] + next.weight;
					q.offer(new Node(next.node, dist[next.node]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sight = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if(Integer.parseInt(st.nextToken()) == 1) sight[i] = true;
			else sight[i] = false;
		}
		
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		
		dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;
		dijkstra();
		
		if(dist[N - 1] == Long.MAX_VALUE) System.out.println("-1");
		else System.out.println(dist[N - 1]);
		
	}

}
