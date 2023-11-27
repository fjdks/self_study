package BOJ_10282;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, d, c;
	static int[] dist;
	static boolean[] v;
	static int cnt;
	static ArrayList<Node>[] coms;
	
	static class Node implements Comparable<Node> {
		int end, s;
		
		public Node(int end, int s) {
			this.end = end;
			this.s = s;
		}

		@Override
		public int compareTo(Node o) {
			return s - o.s;
		}
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(c, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(v[cur.end]) continue;
			
			v[cur.end] = true;
			cnt++;
			
			for (int i = 0; i < coms[cur.end].size(); i++) {
				Node next = coms[cur.end].get(i);
				if(dist[next.end] > dist[cur.end] + next.s) {
					dist[next.end] = dist[cur.end] + next.s;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			coms = new ArrayList[n + 1];
			for (int i = 0; i < n + 1; i++) coms[i] = new ArrayList<>();
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				coms[b].add(new Node(a, s));
			}
			
			cnt = 0;
			dist = new int[n + 1];
			v = new boolean[n + 1];
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[c] = 0;
			dijkstra();
			
			int time = 0;
			for (int i = 1; i <= n; i++) {
				if(dist[i] != Integer.MAX_VALUE) time = Math.max(time, dist[i]);
			}
			
			System.out.println(cnt + " " + time);
			
		}
	}

}
