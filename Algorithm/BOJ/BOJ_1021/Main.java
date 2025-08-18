package BOJ_1021;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, cnt;
	static int[] nums;
	static LinkedList<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) q.add(i);
		nums = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int idx = q.indexOf(nums[i]);
			int half_idx = (q.size() % 2 == 0 ? (q.size() / 2 - 1) : q.size() / 2);
			
			if(idx <= half_idx) {
				for (int j = 0; j < idx; j++) {
					q.add(q.pollFirst());
					cnt++;
				}
			} else {
				for (int j = 0; j < q.size() - idx; j++) {
					q.addFirst(q.pollLast());
					cnt++;
				}
			}
			q.pollFirst();
		}
		System.out.println(cnt);
	}

}
