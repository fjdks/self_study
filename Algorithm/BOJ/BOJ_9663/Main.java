package BOJ_9663;

import java.io.*;

public class Main {
	
	static int N, cnt;
	static int[] board;
	
	static void nQueen(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			board[depth] = i;
			if(check(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	
	static boolean check(int column) {
		for (int i = 0; i < column; i++) {
			// 세로 체크
			if(board[i] == board[column]) return false;
			// 대각선 체크
			else if(Math.abs(column - i) == Math.abs(board[column] - board[i])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		board = new int[N];
		nQueen(0);
		System.out.println(cnt);
	}

}
