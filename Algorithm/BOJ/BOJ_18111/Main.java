package BOJ_18111;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] ground;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int min = 256;
		int max = 0;
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				if(min > arr[n][m]) min = arr[n][m];
				if(max < arr[n][m]) max = arr[n][m];
			}
			
		}
		
		int time = 99999999;
		int high = 0;
		
		for (int i = min; i < max; i++) {
			int cnt = 0;
			int block = B;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(i < arr[j][k]) {
						cnt += (arr[j][k] - i) * 2;
						block += arr[j][k] - i;
					} else {
						cnt += i - arr[j][k];
						block -= i - arr[j][k];
					}
				}
			}
			if(block < 0) break;
			if(time >= cnt) {
				time = cnt;
				high = i;
			}
			
		}
		System.out.println(time + " " + high);
	}

}