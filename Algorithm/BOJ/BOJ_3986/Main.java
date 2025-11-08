package BOJ_3986;

import java.io.*;
import java.util.*;

public class Main {

	static boolean check(String input) {
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			if(s.isEmpty()) s.add(input.charAt(i));
			else {
				if(s.peek() == input.charAt(i)) s.pop();
				else s.add(input.charAt(i));
			}
		}
		
		return s.isEmpty() ? true : false;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if(check(input)) cnt++;
		}
		System.out.println(cnt);
	}

}
