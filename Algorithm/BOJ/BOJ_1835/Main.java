package BOJ_1835;

import java.io.*;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		int idx = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				idx = (idx + 1) % N;
				while(arr[idx] != 0) idx = (idx + 1) % N; 
			}
			arr[idx] = i;
			while(arr[idx] != 0) idx = (idx + 1) % N; 
		}
		for (int i = 0; i < N; i++) System.out.println(arr[i] != 0 ? arr[i] : N);
	}

}
