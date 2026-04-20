package BOJ_1197;

import java.io.*;
import java.util.*;

public class Main_kruskal {
	
	static int[] parent;
	
	static int find(int x) {
		if(parent[x] == x) return parent[x];
		else return find(parent[x]);
	}
	
	static void union(int x, int y){
		x = find(x);
		y = find(y);
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	static int kruskal(int[][] graph) {
		int cnt = 0;
		for(int i = 0; i < graph.length; i++) {
			if(find(graph[i][0]) != find(graph[i][1])) {
				cnt += graph[i][2];
				union(graph[i][0], graph[i][1]);
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[E][3];
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[e] = new int[] {A, B, C};
		}
		
		parent = new int[V + 1];
		for(int v = 0; v <= V; v++) parent[v] = v;
		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		
		System.out.println(kruskal(graph));
	}

}
