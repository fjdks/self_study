package BOJ_2504;

import java.io.*;
import java.util.*;

public class Main {
	
	static int ans, val;
	static boolean flag;
	static Stack<Character> stack = new Stack<>();; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		val = 1;
		ans = 0;
		flag = true;
		for (int i = 0; i < S.length(); i++) {
			char cur = S.charAt(i);
			if(cur == '(') {
				stack.add(cur);
				val *= 2;
			} else if(cur == '[') {
				stack.add(cur);
				val *= 3;
			} else if(cur == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					flag = false;
					break;
				}
				if(S.charAt(i - 1) == '(') {
					ans += val;
				}
				stack.pop();
				val /= 2;
			} else if(cur == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					flag = false;
					break;
				}
				if(S.charAt(i - 1) == '[') {
					ans += val;
				}
				stack.pop();
				val /= 3;
			}
		}
		if(!flag || !stack.isEmpty()) System.out.println(0);
		else System.out.println(ans);
	}

}
