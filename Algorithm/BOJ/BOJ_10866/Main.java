package BOJ_10866;

import java.io.*;
import java.util.*;

public class Main {
	
	static int X;
	static String command;
	static ArrayDeque<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if(command.equals("push_front")) {
				X = Integer.parseInt(st.nextToken());
				q.addFirst(X);
			} else if(command.equals("push_back")) {
				X = Integer.parseInt(st.nextToken());
				q.addLast(X);
			} else if(command.equals("pop_front")) {
				System.out.println(q.isEmpty()? -1 : q.pollFirst());
			} else if(command.equals("pop_back")) {
				System.out.println(q.isEmpty()? -1 : q.pollLast());
			} else if(command.equals("size")) {
				System.out.println(q.size());
			} else if(command.equals("empty")) {
				System.out.println(q.isEmpty() ? 1 : 0);
			} else if(command.equals("front")) {
				System.out.println(q.isEmpty()? -1 : q.peekFirst());
			} else if(command.equals("back")) {
				System.out.println(q.isEmpty()? -1 : q.peekLast());
			}
		}
	}

}
