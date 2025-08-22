package BOJ_1331;

import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[][] board = new boolean[7][7];
	
	static void movement(String point) {
		int i = point.charAt(0) - 'A' + 1;
		int j = point.charAt(1) - '0';
		board[i][j] = true;
	}
	
	static boolean check(String A, String B) {
		int x_move = Math.abs((A.charAt(0) - 'A' + 1) - (B.charAt(0) - 'A' + 1));
		int y_move = Math.abs((A.charAt(1) - '0') - (B.charAt(1) - '0'));
		if(x_move == 1 && y_move == 2) return true;
		else if(x_move == 2 && y_move == 1) return true;
		else return false;
	}
	
	static boolean check_board() {
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				if(!board[i][j]) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = "";
		String pre = "";
		String start = "";
		boolean flag = true;
		for (int i = 0; i < 36; i++) {
			input = br.readLine();
			if(pre.equals("")) {
				pre = input;
				start = input;
			}
			else {
				if(!check(pre, input)) {
					flag = false;
					break;
				}
			}
			movement(input);
			pre = input;
		}
		if(!flag || !check_board() || !check(pre, start)) System.out.println("Invalid"); 
		else System.out.println("Valid");
		
	}

}
