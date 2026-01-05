package BOJ_10451;

import java.io.*;
import java.util.*;

public class Main {

	static int cnt;
	static int[] arr;
	static boolean[] v;
	
	static void dfs(int start) {
		v[start] = true;
		if(v[arr[start]]) {
			cnt++;
			return;
		} else dfs(arr[start]); 
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			v = new boolean[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= N; n++) arr[n] = Integer.parseInt(st.nextToken());
			
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				if(!v[i]) dfs(i);
			}
			System.out.println(cnt);
		}
	}

}
