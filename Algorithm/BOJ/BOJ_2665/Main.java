package BOJ_2665;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] map;
	static class Room implements Comparable<Room> {
		int i, j, cnt;
		
		Room(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Room o) {
			return cnt - o.cnt;
		}
		
	}
	
	static int bfs() {
		boolean[][] v = new boolean[n][n];
		PriorityQueue<Room> pq = new PriorityQueue<>();
		
		v[0][0] = true;
		pq.add(new Room(0, 0, 0));
		while(!pq.isEmpty()) {
			Room r = pq.poll();
			if(r.i == n - 1 && r.j == n - 1) return r.cnt;
			
			for (int d = 0; d < 4; d++) {
				int ni = r.i + di[d];
				int nj = r.j + dj[d];
				if(0 <= ni && ni < n && 0 <= nj && nj < n && !v[ni][nj]) {
					v[ni][nj] = true;
					if(map[ni][nj] == 1) pq.add(new Room(ni, nj, r.cnt));
					else pq.add(new Room(ni, nj, r.cnt + 1));
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		
		System.out.println(bfs());
	}

}
