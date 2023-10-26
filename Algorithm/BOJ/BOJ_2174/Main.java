package BOJ_2174;

import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, R1, R2;
	static int[] error_code = {0, 1, 2};
	static int[][] board;
	static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static Robot[] R_list;
	
	static class Robot {
		int num, i, j, d;
		
		public Robot(int num, int i, int j, int d) {
			this.num = num;
			this.i = i;
			this.j = j;
			this.d = d;
		}
	}
	
	static int swap(String dir) {
		int res = -1;
		switch (dir) {
		case "N":
			res = 0;
			break;
		case "E":
			res = 1;
			break;
		case "S":
			res = 2;
			break;
		case "W":
			res = 3;
			break;
		}
		return res;
	}
	
	static int move(int n, String o, int l) {
		int code = 0;
		Robot cur = R_list[n - 1];
		if(!o.equals("F")) {
			l %= 4;
			if(o.equals("L")){
				cur.d = ((cur.d + 4) - l) % 4;
			} else {
				cur.d = (cur.d + l) % 4;
			}
		} else {
			for (int i = 0; i < l; i++) {
				int ni = cur.i + direction[cur.d][0];
				int nj = cur.j + direction[cur.d][1];
				if(0 <= ni && ni < B && 0 <= nj && nj < A) {
					if(board[ni][nj] == 0) {
						board[cur.i][cur.j] = 0;
						cur.i = ni;
						cur.j = nj;
						board[ni][nj] = cur.num;
						code = 0;
					} else {
						R1 = cur.num;
						R2 = board[ni][nj];
						code = 2;
						break;
					}
				} else {
					R1 = cur.num;
					code = 1;
					break;
				}
			}
		}
		R_list[n - 1] = cur;
		return code;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[B][A];
		R_list = new Robot[N];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = B - Integer.parseInt(st.nextToken());
			int dir = swap(st.nextToken());
			board[x][y] = i;
			R_list[i - 1] = new Robot(i, x, y, dir);
		}
		
		int code = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int robot_num = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			int loop = Integer.parseInt(st.nextToken());

			code = move(robot_num, order, loop);
			if(code != 0) break;
		}
		if(code == 0) System.out.println("OK");
		else if(code == 1) System.out.println("Robot " + R1 + " crashes into the wall");
		else System.out.println("Robot " + R1 + " crashes into robot " + R2);
	}

}
