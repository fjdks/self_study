package BOJ_1406;

import java.io.*;

public class Main2 {
	
	static int cursor;
	static StringBuilder sb;
	static char[][] order;
	
	static void commands(char[] o) {
		switch (o[0]) {
		case 'P':
			sb.insert(cursor, o[1]);
			cursor++;
			break;
		case 'L':
			if (cursor > 0) cursor--;
			break;
		case 'D':
			if(cursor < sb.length()) cursor++;
			break;
		case 'B':
			if (cursor > 0) {
				sb.deleteCharAt(cursor - 1);
				cursor--;
			}
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		String input = br.readLine();
		cursor = input.length();
		for (int i = 0; i < input.length(); i++) sb.append(input.charAt(i));
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
		
		System.out.println(sb);
	}

}
