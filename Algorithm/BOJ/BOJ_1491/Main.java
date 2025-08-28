package BOJ_1491;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] di = {0, -1, 0, 1};
	static int[] dj = {1, 0, -1, 0};
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		v = new boolean[M][N];
		
		int[] cur_pos = {M - 1, 0};
		int cd = 0;
		v[M - 1][0] = true;
		
		for (int i = 1; i <= N * M; i++) {
			if(i == N * M) {
				System.out.println(cur_pos[1] + " " + (M - cur_pos[0] - 1));
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ni = cur_pos[0] + di[cd];
				int nj = cur_pos[1] + dj[cd];
				if(0 <= ni && ni < M && 0 <= nj && nj < N && !v[ni][nj]) {
					cur_pos = new int[] {ni, nj};
					v[ni][nj] = true;
					break;
				} else cd = (cd + 1) % 4;
			}
		}
	}

}
