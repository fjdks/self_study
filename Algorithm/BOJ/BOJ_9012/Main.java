package BOJ_9012;

import java.io.*;
import java.util.Stack;

public class Main {
	
	static Stack<Character> s = new Stack<>();
	static String line;
	static char cur;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		loop:for (int tc = 0; tc < T; tc++) {
			s.clear();
			line = br.readLine();
			for (int i = 0; i < line.length(); i++) {
				cur = line.charAt(i);
				if(cur == '(') {
					s.add(cur);
				} else if(cur == ')') {
					if(s.isEmpty()) {
						System.out.println("NO");
						continue loop;
					} else {
						if(s.peek() == '(') {
							s.pop();
						}
					}
				}
			}
			if(s.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
