package BOJ_1966;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static boolean find;
	static ArrayDeque<int[]> q, temp;
	static ArrayList<Integer> order;

	static void print() {
		int[] cur = q.peekFirst();
		int max_importance = cur[0];
		int max_idx = cur[1];
		while(!q.isEmpty()) {
			cur = q.pollFirst();
			if(cur[0] > max_importance) {
				max_importance = cur[0];
				max_idx = cur[1];
			}
			temp.add(cur);
		}
		while(true) {
			cur = temp.pollFirst();
			if(cur[1] == max_idx) {
				order.add(cur[1]);
				if(cur[1] == M) find = true;
				while(!temp.isEmpty()) {
					q.add(temp.pollFirst());
				}
				break;
			} else {
				temp.add(cur);
			}
		}
	}
	
	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			q = new ArrayDeque<>();
			temp = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				q.add(new int[] {Integer.parseInt(st.nextToken()), i});
			}
			order = new ArrayList<>();
			
			find = false;
			while(!find) print();
			System.out.println(order.size());
			
		}

	}

}
