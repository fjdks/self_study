package BOJ_4949;

import java.io.*;
import java.util.*;

public class Main {
	
	static String line;
	
	static Stack<Character> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		stack = new Stack<>();
		while(true) {
			line = br.readLine();
			if(line.equals(".")) break;
			for (int i = 0; i < line.length(); i++) {
//				System.out.print(line.charAt(i));
//				System.out.print(stack.size());
//				System.out.print(' ');
				if(line.charAt(i) == '.') {
					if(stack.isEmpty()) System.out.println("yes");
					else System.out.println("no");
					stack.clear();
					break;
				}
				else if(line.charAt(i) == '(') stack.add('(');
				else if(line.charAt(i) == ')') {
					if(stack.isEmpty()) {
						System.out.println("no");
						stack.clear();
						break;
					}
					else if(stack.peek() == '(') {
						stack.pop();
					} else {
						System.out.println("no");
						stack.clear();
						break;
					}
				}
				else if(line.charAt(i) == '[') stack.add('[');
				else if(line.charAt(i) == ']') {
					if(stack.isEmpty()) {
						System.out.println("no");
						stack.clear();
						break;
					}
					else if(stack.peek() == '[') {
						stack.pop();
					} else {
						System.out.println("no");
						stack.clear();
						break;
					}
				}
			}
		}
		
	}
}
