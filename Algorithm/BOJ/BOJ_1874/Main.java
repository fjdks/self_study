package BOJ_1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> command = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		boolean flag = true;
		int n = Integer.parseInt(br.readLine());
		int cur = 0;
//		for (int i = 1; i <= n; i++) {
//			int next = Integer.parseInt(br.readLine());
//			
//			if (stack.isEmpty() || stack.peek() < next) {
//				for (int j = cur + 1; j <= next; j++) {
//					stack.push(j);
//					command.add("+");
//				}
//				cur = next;
//			} 
//			if (i < n && stack.isEmpty()) {
//				flag = false;
//				break;
//			}
//			System.out.println("top : " + stack.peek());
//			
//			int top = 0;
//			while(top != next) {
//				top = stack.pop();
//				command.add("-");
//			}
//		}
//		
//		if(!flag) System.out.println("NO");
//		else {
//			for (int i = 0; i < command.size(); i++) {
//				System.out.println(command.get(i));
//			}
//		}
		
		
		while(n-- > 0) {
			int next = Integer.parseInt(br.readLine());
			
			if (stack.isEmpty() || stack.peek() < next) {
				for (int j = cur + 1; j <= next; j++) {
					stack.push(j);
					command.add("+");
				}
				cur = next;
			} else if(stack.peek() != next) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			command.add("-");
		}
		
		for (int i = 0; i < command.size(); i++) {
			System.out.println(command.get(i));
		}
	}

}
