package BOJ_18352;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, X;
	static int[] dist;
	static List<List<City>> list;
	
	static class City implements Comparable<City>{
		int cityNum, weight;
		
		public City(int c, int w){
			this.cityNum = c;
			this.weight = w;
		}
		
		@Override
		public int compareTo(City o) {
			return weight -o.weight;
		}
	}
	
	static void dijkstra(int cityNum) {
		PriorityQueue<City> q = new PriorityQueue<>();
		boolean[] v = new boolean[N + 1];
		dist[cityNum] = 0;
		
		q.offer(new City(cityNum, 0));
		while(!q.isEmpty()) {
			City city = q.poll();
			int num = city.cityNum;
			
			if(v[num]) continue;
			
			v[num] = true;
			
			for(City c : list.get(num)) {
				// c : 기존의 루트
				// num : 새로 선택한 루트
				if(!v[c.cityNum] && dist[c.cityNum] > (c.weight + dist[num])) {
					dist[c.cityNum] = c.weight + dist[num];
					q.offer(new City(c.cityNum, dist[c.cityNum]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(new City(y, 1));
		}
		
		dijkstra(X);
		
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] == K) sb.append(i).append('\n');
		}
		
		if(sb.length() == 0) System.out.println(-1);
		else System.out.println(sb);
		
	}

}
