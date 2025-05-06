package BOJ_1406;

import java.io.*;
import java.util.*;

public class Main {
	
	static int cursor;
	static ArrayDeque<Character> arr = new ArrayDeque<Character>();
	static char[][] order;
	
	static void commands(char[] o) {
		switch (o[0]) {
		case 'P':
			add_char(o[1]);
			break;
		case 'L':
			if (cursor > 0) cursor--;
			break;
		case 'D':
			if(cursor < arr.size()) cursor++;
			break;
		case 'B':
			if (cursor > 0) del_char();
			break;
		default:
			break;
		}
	}
	
	static void add_char(char c) {
		Stack<Character> temp = new Stack<Character>();
		
		while(arr.size() > cursor) temp.add(arr.pollLast());
		arr.add(c);
		while(!temp.isEmpty()) arr.add(temp.pop());
		cursor++;
	}
	
	static void del_char() {
		Stack<Character> temp = new Stack<Character>();
		
		while(arr.size() > cursor) temp.add(arr.pollLast());
		arr.pollLast();
		while(!temp.isEmpty()) arr.add(temp.pop());
		cursor--;
	}
	
//	static void show() {
//		ArrayDeque<Character> temp = new ArrayDeque<Character>();
//		temp = arr.clone();
//		String output = "";
//		for (int i = 0; i < temp.size(); i++) {
//			output += temp.pollFirst();
//		}
//		
//		System.out.println(output);
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) arr.add(input.charAt(i));
		cursor = input.length();
		
		int M = Integer.parseInt(br.readLine());

		order = new char[M][2];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(s.charAt(0) == 'P') {
				order[i][0] = 'P';
				order[i][1] = s.charAt(2);
			} else order[i][0] = s.charAt(0);
		}
		
		for (int i = 0; i < M; i++) {
			commands(order[i]);
		}
		
		String output = "";
		int size = arr.size();
		for (int i = 0; i < size; i++) {
			output += arr.pollFirst();
		}
		System.out.println(output);
		
	}

}
