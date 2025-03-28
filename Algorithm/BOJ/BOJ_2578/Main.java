package BOJ_2578;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static boolean[][] called;
	
	static void search(int x) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(board[i][j] == x) {
					called[i][j] = true;
				}
			}
		}
	}
	
	static boolean check() {
		int cnt = 0;
		int lines = 0;
		
		// 가로
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if(called[i][j]) cnt++;
			} 
			if(cnt == 5) lines++;
		}
		
		//세로
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if(called[j][i]) cnt++;
			}
			if(cnt == 5) lines++;
		}
		
		//대각선(우하)
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if(called[i][i]) cnt++;
		}
		if(cnt == 5) lines++;
	
		//대각선(좌상)
		cnt = 0;
		for (int i = 4; i >= 0; i--) {
			if(called[i][4 - i]) cnt++;
		}
		if(cnt == 5) lines++;
		
		if(lines >= 3) return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		board = new int[5][5];
		called = new boolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int num = 0;
		loop: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				num = Integer.parseInt(st.nextToken());
				search(num);
				// 사회자가 부른 숫자가 10번째가 넘어가면
				// "빙고"를 외치려면 최소 10개의 수는 넘어야 함
				if(cnt >= 10) {
					if(check()) break loop;
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}

}
