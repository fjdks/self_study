package BOJ_2346;

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayDeque<Balloons> balloons = new ArrayDeque<Balloons>();
	
	static class Balloons {
		int balloon;
		int paper;
		
		public Balloons(int balloon, int paper) {
			this.balloon = balloon;
			this.paper = paper;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) balloons.add(new Balloons(i + 1, Integer.parseInt(st.nextToken())));

		Balloons cur = new Balloons(0,0);
		while(balloons.size() > 1) {
			cur = balloons.pop();
			sb.append(cur.balloon).append(" ");
			if(cur.paper > 0) {
				for (int i = 0; i < cur.paper - 1; i++) balloons.add(balloons.pop());
			} else {
				for (int i = 0; i < Math.abs(cur.paper); i++) balloons.addFirst(balloons.pollLast());
			}
		}
		cur = balloons.pop();
		sb.append(cur.balloon).append(" ");
		System.out.println(sb);
	}

}
