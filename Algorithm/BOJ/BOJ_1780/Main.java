package BOJ_1780;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, minus, zero, plus;
	static int[][] paper;
	
	static boolean check(int start_i, int start_j, int len) {
		boolean flag = true;
		int value = paper[start_i][start_j];
		for (int i = start_i; i < start_i + len; i++) {
			if(!flag) break;
			for (int j = start_j; j < start_j + len; j++) {
				if(paper[i][j] != value) flag = false;
			}
		}
		return flag;
	}
	
	static void cut(int start_i, int start_j, int len) {
//		System.out.println(minus);
//		System.out.println(zero);
//		System.out.println(plus);
//		System.out.println("--------------");
		if(len == 1 || check(start_i, start_j, len)) {
			int cur = paper[start_i][start_j];
			if(cur == -1) minus++;
			else if(cur == 0) zero++;
			else if(cur == 1) plus++;
			return;
		} else {
			len /= 3;
			cut(start_i, start_j, len);
			cut(start_i + len, start_j, len);
			cut(start_i + len * 2, start_j, len);
			
			cut(start_i, start_j + len, len);
			cut(start_i + len, start_j + len, len);
			cut(start_i + len * 2, start_j + len, len);
			
			cut(start_i, start_j + len * 2, len);
			cut(start_i + len, start_j + len * 2, len);
			cut(start_i + len * 2, start_j + len * 2, len);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minus = 0;
		zero = 0;
		plus = 0;
		
		cut(0, 0, N);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

}
