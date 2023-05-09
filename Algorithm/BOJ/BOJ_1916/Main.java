package BOJ_1916;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] dist;
	static boolean[] v;
	static ArrayList<ArrayList<Bus>> bus;
	
	static class Bus implements Comparable<Bus>{
		int end;
		int cost;
		
		Bus(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bus o) {
			return cost - o.cost;
		}
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		v = new boolean[N + 1];
		pq.offer(new Bus(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Bus curBus = pq.poll();
			int cur = curBus.end;
			
			if(!v[cur]) {
				v[cur] = true;
			
				for(Bus newbus : bus.get(cur)) {
					if(!v[newbus.end] && dist[newbus.end] > dist[cur] + newbus.cost) {
						dist[newbus.end] = dist[cur] + newbus.cost;
						pq.add(new Bus(newbus.end, dist[newbus.end]));
					}
				}
			}
		}
		return dist[end];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		bus = new ArrayList<>();
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i <= N; i++) {
			bus.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			bus.get(start).add(new Bus(end, cost));
		}

		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(A, B));
		
	}
}
