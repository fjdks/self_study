package BOJ_1895;

import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, T, cnt;
	static int[][] I;
	static ArrayList<Integer> nums;
	
	static void filtering(int center_i, int center_j) {
		nums = new ArrayList<Integer>();
		for (int i = center_i - 1; i <= center_i + 1; i++) {
			for (int j = center_j - 1; j <= center_j + 1; j++) {
				nums.add(I[i][j]);
			}
		}
		Collections.sort(nums);
		if(nums.get(4) >= T) cnt++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		I = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				I[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		T = Integer.parseInt(br.readLine());
		cnt = 0;
		
		for (int i = 1; i < R - 1; i++) {
			for (int j = 1; j < C - 1; j++) {
				filtering(i, j);
			}
		}
	
		System.out.println(cnt);
	}

}
