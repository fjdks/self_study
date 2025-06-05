package BOJ_24480;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R, cnt;
	static int[] order;
	static ArrayList<ArrayList<Integer>> graph;
	
	static void dfs(int start) {
		order[start] = cnt;
		
		for (int i = 0; i < graph.get(start).size(); i++) {
			int ni = graph.get(start).get(i);
			if(order[ni] == 0) {
				cnt++;
				dfs(ni);
			}
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int n = 0; n < N + 1; n++) {
			graph.add(new ArrayList<>());
		}
		
		order = new int[N + 1];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		cnt = 1;
		dfs(R);
		for (int i = 1; i < order.length; i++) {
			System.out.println(order[i]);
		}
	}
}
