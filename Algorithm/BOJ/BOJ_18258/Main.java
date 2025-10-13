package BOJ_18258;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayDeque<Integer> q = new ArrayDeque<Integer>();
	static StringBuilder sb = new StringBuilder();
	static int num;
	
	static void command(String c) {
		Integer item = 0;
		switch (c) {
		case "push":
			q.add(num);
			break;
		case "pop":
			item = q.poll();
			if(item == null) sb.append(-1);
			else sb.append(item);
			break;
		case "size":
			sb.append(q.size());
			break;
		case "empty":
			sb.append(q.isEmpty() ? 1 : 0);
			break;
		case "front":
			item = q.peek();
			if(item == null) sb.append(-1);
			else sb.append(item);
			break;
		case "back":
			item = q.peekLast();
			if(item == null) sb.append(-1);
			else sb.append(item);
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		q.clear();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) num = Integer.parseInt(st.nextToken());
			
			command(cmd);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}

