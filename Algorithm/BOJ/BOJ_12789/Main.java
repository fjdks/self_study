package BOJ_12789;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) deque.add(Integer.parseInt(st.nextToken()));
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int now = 1;
		int cnt = 0;
		while(cnt != N) {
			System.out.println("-------------");
			System.out.println(deque.toString());
			System.out.println(stack.toString());
			System.out.println("-------------");
			if(!deque.isEmpty() && (deque.peek() == now)) {
				now++;
				cnt++;
				deque.pop();
			} else {
				if(!stack.isEmpty() && (stack.peek() == now)) {
					now++;
					cnt++;
					stack.pop();
				} else {
					if(deque.isEmpty()) break;
					stack.add(deque.pop());
				}
			}
		}

		System.out.println(cnt == N ? "Nice" : "Sad");
		
	}

}
