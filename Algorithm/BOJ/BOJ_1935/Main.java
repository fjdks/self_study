package BOJ_1935;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String exp = br.readLine();
		
		int[] sub = new int[N];
		for (int i = 0; i < N; i++) sub[i] = Integer.parseInt(br.readLine());
		
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < exp.length(); i++) {
			if('A' <= exp.charAt(i) && exp.charAt(i) <= 'Z') stack.add((double)sub[exp.charAt(i) - 65]);
			else {
				double b = stack.pop();
				double a = stack.pop();
				switch (exp.charAt(i)) {
				case '+':
					stack.add(a + b);
					break;
				case '-':
					stack.add(a - b);
					break;
				case '*':
					stack.add(a * b);
					break;
				case '/':
					stack.add(a / b);
					break;
				default:
					break;
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
//		System.out.printf("%.2f", Math.floor((stack.pop() * 100)) / 100.0);
		
	}

}
