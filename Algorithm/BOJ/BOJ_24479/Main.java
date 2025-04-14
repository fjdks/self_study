package BOJ_24479;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R, cnt;
	
	static ArrayList<ArrayList<Integer>> graph;
	static int[] order;
	
	static void dfs(int R) {
		order[R] = cnt;
		for(int i = 0; i < graph.get(R).size(); i++) {
			int ni = graph.get(R).get(i);
			if(order[ni] == 0) {
				cnt++;
				dfs(ni);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		order = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
			
		}
		
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		
		cnt = 1;
		dfs(R);
		
		
		for(int i = 1; i < order.length; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
		
	}

}
