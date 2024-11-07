package BOJ_17413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static ArrayDeque<Character> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		int len = S.length();
		
		boolean flag = true;
		for (int i = 0; i < len; i++) {
			if(S.charAt(i) == ' ') {
				if(!flag) {
					dq.add(' ');
					continue;
				}
				while(!dq.isEmpty()) sb.append(dq.pollLast());
				sb.append(' ');
			} else if(S.charAt(i) == '<'){
				flag = false;
				while(!dq.isEmpty()) sb.append(dq.pollLast());
				sb.append('<');
			}
			else if(S.charAt(i) == '>') {
				flag = true;
				dq.add(S.charAt(i));
				while(!dq.isEmpty()) sb.append(dq.pollFirst());
			} else {
				dq.add(S.charAt(i));
			}
		}
		while(!dq.isEmpty()) sb.append(dq.pollLast());
		System.out.println(sb);
	}

}
