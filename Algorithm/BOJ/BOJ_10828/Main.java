package BOJ_10828;

import java.io.*;
import java.util.*;

public class Main {
	
	static int X;
	static String command;
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if(command.equals("push")) {
				X = Integer.parseInt(st.nextToken());
				s.add(X);
			} else if(command.equals("pop")) {
				System.out.println(s.isEmpty()? -1 : s.pop());
			} else if(command.equals("size")) {
				System.out.println(s.size());
			} else if(command.equals("empty")) {
				System.out.println(s.isEmpty() ? 1 : 0);
			} else if(command.equals("top")) {
				System.out.println(s.isEmpty()? -1 : s.peek());
			}
			
		}
	}

}
