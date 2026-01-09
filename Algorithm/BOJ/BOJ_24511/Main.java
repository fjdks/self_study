package BOJ_24511;

import java.io.*;
import java.util.*;

public class Main {
	
	static List<Queue<Integer>> list = new ArrayList<Queue<Integer>>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N]; 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		int[] C = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) C[i] = Integer.parseInt(st.nextToken());
		//------------------
		
		ArrayList<Integer> qs = new ArrayList<Integer>();
		
		int idx = N - 1;
		while(qs.size() <= M) {
			if(idx < 0) break;
			else if(A[idx] == 0) qs.add(B[idx]);
			idx--;
		}
		for (int i = 0; i < M; i++) qs.add(C[i]);
		
		for (int i = 0; i < M; i++) sb.append(qs.get(i)).append(" ");
		System.out.println(sb);
		
//		for (int i = 0; i < N; i++) {
//			if(A[i] == 0) {
//				Queue<Integer> q = new ArrayDeque<Integer>();
//				q.add(B[i]);
//				list.add(q);
//			}
//		}
//		
//		if(list.size() == 0) {
//			for (int i = 0; i < M; i++) sb.append(C[i]).append(" ");
//		} else {
//			ArrayList<Integer> qs = new ArrayList<Integer>();
//			
//			for (int i = 0; i < M; i++) {
//				list.get(0).offer(C[i]);
//				int p = 0;
//				if(list.size() > 1) {
//					for (int j = 0; j < list.size() - 1; j++) {
//						p = list.get(j).poll();
//						list.get(j + 1).offer(p);
//					}
//				}
//				p = list.get(list.size() - 1).poll();
//				qs.add(p);
//			}
//	
//			for (int i = 0; i < qs.size(); i++) sb.append(qs.get(i)).append(" ");
//		}
//		
//		System.out.println(sb);
	}

}
