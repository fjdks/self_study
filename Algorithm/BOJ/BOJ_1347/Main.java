package BOJ_1347;

import java.io.*;
import java.util.*;

public class Main {
	
	static int L;
	static int[] start_point = new int[2];
	static int[] di = new int[] {1, 0, -1, 0};	// 하 우 상 좌
	static int[] dj = new int[] {0, 1, 0, -1};
	static char[][] maze;
	static String route;
	
	static int[] check_maze_size() {
		int[] cur_pos = new int[] {0, 0};
		int V_min = 0;
		int V_max = 0;
		int H_min = 0;
		int H_max = 0;
		
		int D = 0;
		
		for (int i = 0; i < route.length(); i++) {
			char command = route.charAt(i);
			switch (command) {
			case 'F':
				cur_pos = new int[] {cur_pos[0] + di[D], cur_pos[1] + dj[D]};
				break;
				
			case 'L':
				D = (D + 1) % 4;
				break;
				
			case 'R':
				D = (D + 3) % 4;
				break;

			default:
				break;
			}
			
			V_min = Math.min(cur_pos[0], V_min);
			V_max = Math.max(cur_pos[0], V_max);
			H_min = Math.min(cur_pos[1], H_min);
			H_max = Math.max(cur_pos[1], H_max);
		}
		
//		System.out.println("V_min : " + V_min);
//		System.out.println("V_max : " + V_max);
//		System.out.println("H_min : " + H_min);
//		System.out.println("H_max : " + H_max);
		
		start_point = new int[] {Math.abs(V_min), Math.abs(H_min)};
		
		return new int[] {Math.abs(V_max - V_min) + 1, Math.abs(H_max - H_min) + 1};
	}
	
	static char[][] make_maze(int[] s) {
		maze = new char[s[0]][s[1]];	// H, V confuse
//		System.out.println(maze[0].length);
		for (int i = 0; i < s[0]; i++) {
			Arrays.fill(maze[i], '#');
		}
		
//		for (int i = 0; i < s[0]; i++) {
//			for (int j = 0; j < s[1]; j++) {
//				System.out.print(maze[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		maze[start_point[0]][start_point[1]] = '.';
		
		
		int D = 0;
		int[] cur_pos = start_point;
		for (int i = 0; i < route.length(); i++) {
			char command = route.charAt(i);
			switch (command) {
			case 'F':
				cur_pos = new int[] {cur_pos[0] + di[D], cur_pos[1] + dj[D]};
				maze[cur_pos[0]][cur_pos[1]] = '.';
				break;
				
			case 'L':
				D = (D + 1) % 4;
				break;
				
			case 'R':
				D = (D + 3) % 4;
				break;

			default:
				break;
			}
		}
		
		return maze;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		L = Integer.parseInt(br.readLine());
		route = br.readLine();
		
		int[] size = check_maze_size();
//		System.out.println(size[0] + ", " + size[1]);
		
		make_maze(size);
		for (int i = 0; i < size[0]; i++) {
			for (int j = 0; j < size[1]; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		
		
	}

}
