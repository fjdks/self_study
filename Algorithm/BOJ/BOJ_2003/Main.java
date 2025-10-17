package BOJ_2003;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] A;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int left = 0;
		int right = 0;
		
		int cnt = 0;
		int sum = A[0];
		while(true) {
			if(sum == M) {
				cnt++;
				if(right == N - 1) break;
				sum -= A[left++];
				sum += A[++right];
			} else if(sum > M) sum -= A[left++];
			else if(sum < M) {
				if(right == N - 1) break;
				sum += A[++right];
			}
		}
		System.out.println(cnt);
	}

}
