package BOJ_1080;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, cnt;
	static int[][] matrix_A, matrix_B;
	
	static boolean is_same_matrix() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix_A[i][j] != matrix_B[i][j]) return false;
			}
		}
		return true;
	}
	
	static void switch_board(int y, int x) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				matrix_A[i][j] = (matrix_A[i][j] == 0 ? 1 : 0); 
			}
		}
	}
	
	
	static int main_task() {
		cnt = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if(matrix_A[i][j] != matrix_B[i][j]) {
					cnt++;
					switch_board(i, j);
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix_A = new int[N][M];
		matrix_B = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix_A[i][j] = line.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix_B[i][j] = line.charAt(j) - '0';
			}
		}
		
		
		if(N < 3 || M < 3) {
			if(is_same_matrix()) System.out.println(0);
			else System.out.println(-1);
		} else {
			main_task();
			if(!is_same_matrix()) System.out.println(-1);
			else System.out.println(cnt);
		}
		
		
	}

}
