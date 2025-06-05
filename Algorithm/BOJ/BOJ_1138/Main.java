package BOJ_1138;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] info, order;

	static void get_order(int num) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(order[i] == 0) {
				if(cnt == info[num]) {
					order[i] = num + 1;
					break;
				} else cnt++;
			} 
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		info = new int[N];
		order = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) info[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			get_order(i);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(order[i] + " ");
		}

	}

}
