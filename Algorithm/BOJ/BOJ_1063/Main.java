package BOJ_1063;

import java.io.*;
import java.util.*;

public class Main {
	
	static String[] task = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
	
	static int[] king_pos, stone_pos;
	
	static int N;
	
	static int[] String_to_xy(String position) {
		return new int[] {position.charAt(0) - 65, Character.getNumericValue(position.charAt(1)) - 1};
	}
	
	static String xy_to_String(int[] xy) {
		char x = (char)(xy[0] + 65);
		char y = (char)((xy[1] + 1) +'0');
		return x + "" + y;
	}
	
	static boolean check(int[] target) {
		if(target[0] < 0 || 7 < target[0] || target[1] < 0 || 7 < target[1]) return false;
		return true;
	}
	
	static void move(String order) {
		int task_num = -1;
		for (int i = 0; i < 8; i++) {
			if(task[i].equals(order)) {
				task_num = i;
//				System.out.println("task 번호 : " + task_num);
				break;
			}
		}
		
		int[] temp_k = new int[2];
		int[] temp_s = new int[2];
		int nkx = king_pos[0] + dx[task_num];
		int nky = king_pos[1] + dy[task_num];
		
		temp_k = new int[] {nkx, nky};
		
//		System.out.println(check(temp_k));
		if(!check(temp_k)) return;
		else if(stone_pos[0] == temp_k[0] && stone_pos[1] == temp_k[1]) {
//			System.out.println("겹쳤다!");
			int nsx = stone_pos[0] + dx[task_num];
			int nsy = stone_pos[1] + dy[task_num];
			
			temp_s = new int[] {nsx, nsy};
			if(!check(temp_s)) return;
			king_pos = temp_k;
			stone_pos = temp_s;
			
		} else {
			king_pos = temp_k;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		king_pos = String_to_xy(st.nextToken());
		stone_pos = String_to_xy(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
//		System.out.println(Arrays.toString(king_pos));
//		System.out.println(Arrays.toString(stone_pos));
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
//			System.out.println("----------");
//			System.out.println((i + 1) + "번째 태스크");
			move(st.nextToken());
//			System.out.println(Arrays.toString(king_pos));
//			System.out.println(Arrays.toString(stone_pos));
//			System.out.println("----------");
		}
		
		System.out.println(xy_to_String(king_pos));
		System.out.println(xy_to_String(stone_pos));
	}

}
