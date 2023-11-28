package BOJ_14497;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] dist, classroom;
	
	static class Point implements Comparable<Point>{
		int i, j, cnt;
		
		Point(int i, int j, int cnt){
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		public int compareTo(Point o) {
			return cnt - o.cnt;
		}
	}
	
	static void dijkstra(int junan_i, int junan_j) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] v = new boolean[N][M];
		
		dist[junan_i][junan_j] = 0;
		pq.add(new Point(junan_i, junan_j, dist[junan_i][junan_j]));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(v[cur.i][cur.j]) continue;
			
			v[cur.i][cur.j] = true;
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				
				if(ni < 0 || N <= ni || nj < 0 || M <= nj) continue;
				
				if(dist[ni][nj] > dist[cur.i][cur.j] + classroom[ni][nj]) {
					dist[ni][nj] = dist[cur.i][cur.j] + classroom[ni][nj];
					pq.add(new Point(ni, nj, dist[ni][nj]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y1 = Integer.parseInt(st.nextToken()) - 1;
		int x2 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;
		
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		classroom = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = line.charAt(j);
				if(c == '0' || c == '*') classroom[i][j] = 0;		// 빈공간, 주난
				else if(c == '1' || c == '#') classroom[i][j] = 1;	// 친구들, 범인
			}
		}
		
		dijkstra(x1, y1);
		System.out.println(dist[x2][y2]);
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(classroom[i]));
		
		
		
	}

}
