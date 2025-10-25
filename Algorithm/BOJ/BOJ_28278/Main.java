package BOJ_28278;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static StringTokenizer st = null;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	static void command(String input) {
		st = new StringTokenizer(input);
		int c = Integer.parseInt(st.nextToken());
		switch (c) {
		case 1:
			stack.add(Integer.parseInt(st.nextToken()));
			break;
		case 2:
			sb.append(!stack.isEmpty() ? stack.pop() : -1);
			sb.append("\n");
			break;
		case 3:
			sb.append(stack.size());
			sb.append("\n");
			break;
		case 4:
			sb.append(stack.isEmpty() ? 1 : 0);
			sb.append("\n");
			break;
		case 5:
			sb.append(!stack.isEmpty() ? stack.peek() : -1);
			sb.append("\n");
			break;
		default:
			break;
		} 
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			command(line);
		}
		System.out.println(sb);
	}

}
