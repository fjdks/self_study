package BOJ_1730;

import java.io.*;
import java.util.*;

public class Main {

	static char[][] board;
	static int[] cur_pos, next_pos;
	static int N;
	static char cur_pt, next_pt;
	
	static void print() {
		System.out.println("--------------------");
		System.out.println("cur_pos : " + Arrays.toString(cur_pos));
		System.out.println("next_pos : " + Arrays.toString(next_pos));
		System.out.println("cur_pt : " + cur_pt);
		System.out.println("next_pt : " + next_pt);
		for (int i = 0; i < N; i++) {
			for(char c : board[i]) System.out.print(c);
			System.out.println();
		}
		System.out.println("--------------------");
	}
	
	static int[] get_next_pos(char command, int[] cp) {
		int[] np = new int[2];
		switch (command) {
		case 'U':
			np[0] = Math.max(cp[0] - 1, 0);
			np[1] = cp[1];
			break;
		case 'D':
			np[0] = Math.min(cp[0] + 1, N - 1);
			np[1] = cp[1];
			break;
		case 'L':
			np[0] = cp[0];
			np[1] = Math.max(cp[1] - 1, 0);
			break;
		case 'R':
			np[0] = cp[0];
			np[1] = Math.min(cp[1] + 1, N - 1);
			break;
		}
		return np;
	}
	
	static char get_pattern(char command) {
		if(command == 'D' || command == 'U') {
			return '|';
		} else return '-';
	}
	
	static void marking(char command) {
		if(board[cur_pos[0]][cur_pos[1]] == '.') board[cur_pos[0]][cur_pos[1]] = cur_pt;
		
		if(board[next_pos[0]][next_pos[1]] == '.') board[next_pos[0]][next_pos[1]] = next_pt;
		if(cur_pt != next_pt) board[cur_pos[0]][cur_pos[1]] = '+';
	}
	
	static void movement(char command) {
		next_pos = get_next_pos(command, cur_pos);
		char pt = get_pattern(command);
		
		if(cur_pt == ' ') cur_pt = pt;
		next_pt = pt;
		
//		System.out.println("cur_pos : " + Arrays.toString(cur_pos));
//		System.out.println("next_pos : " + Arrays.toString(next_pos));
		marking(command);
		
//		print();
		cur_pos = next_pos;
		cur_pt = next_pt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String order = br.readLine();
		
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = '.';
			}
		}
		
		cur_pos = new int[] {0, 0};
		next_pos = new int[] {0, 0};
		cur_pt = ' ';
		
		
		
		
		
		
		
		for (int i = 0; i < order.length(); i++) {
			movement(order.charAt(i));
		}
		for (int i = 0; i < N; i++) {
			for(char c : board[i]) System.out.print(c);
			System.out.println();
		}
	}

}
