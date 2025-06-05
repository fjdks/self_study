package BOJ_1261;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] maze;
	
	static class Point implements Comparable<Point>{
		int i, j, cnt;
		
		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Point o) {
			return cnt - o.cnt;
		}
	}
	
	
	
	static int bfs() {
		boolean[][] v = new boolean[N][M];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		pq.add(new Point(0, 0, 0));
		v[0][0] = true;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(p.i == N - 1 && p.j == M - 1) return p.cnt;
			
			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				if(0 <= ni && ni < N && 0 <= nj && nj < M && !v[ni][nj]) {
					v[ni][nj] = true;
					if(maze[ni][nj] == 0) pq.add(new Point(ni, nj, p.cnt));
					else pq.add(new Point(ni, nj, p.cnt + 1));
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
		
		
	}

}
