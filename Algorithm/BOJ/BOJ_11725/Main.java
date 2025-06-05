package BOJ_11725;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] parent;
	static boolean[] v;
	static ArrayList<ArrayList<Integer>> tree;
	
	static void dfs(int nodeIdx) {
		v[nodeIdx] = true;
		for(int i:tree.get(nodeIdx)) {
			if(!v[i]) {
				parent[i] = nodeIdx;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			tree.get(start).add(end);
			tree.get(end).add(start);
		}
		
		v = new boolean[N + 1];
		parent = new int[N + 1];
		
		dfs(1);
		
		for (int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
		
		br.close();
	}
}
