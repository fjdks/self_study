package BOJ_9019;

import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B;
	
	static int D(int n) {
		return (2 * n) % 10000;
	}
	
	static int S(int n) {
		return n == 0? 9999 : n - 1;
	}
	
	static int L(int n) {
		int d1 = n / 1000;
		n %= 1000;
		int d2 = n / 100;
		n %= 100;
		int d3 = n / 10;
		int d4 = n % 10;
		
		return ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
	}
	
	static int R(int n) {
		int d1 = n / 1000;
		n %= 1000;
		int d2 = n / 100;
		n %= 100;
		int d3 = n / 10;
		int d4 = n % 10;
		
		return ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
	}
	
	static void BFS(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[10000];
		String[] command = new String[10000];
		
		q.add(n);
		v[n] = true;
		Arrays.fill(command, "");
		while(!q.isEmpty()) {
			if(v[B]) break;
			int cur = q.poll();
			
			int D = D(cur);
			int S = S(cur);
			int L = L(cur);
			int R = R(cur);
			
			if(!v[D]) {
				q.add(D);
				v[D] = true;
				command[D] = command[cur] + "D";
			}
			if(!v[S]) {
				q.add(S);
				v[S] = true;
				command[S] = command[cur] + "S";
			}
			if(!v[L]) {
				q.add(L);
				v[L] = true;
				command[L] = command[cur] + "L";
			}
			if(!v[R]) {
				q.add(R);
				v[R] = true;
				command[R] = command[cur] + "R";
			}
		}
		System.out.println(command[B]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			BFS(A);
		}
		
		br.close();
	}
}
