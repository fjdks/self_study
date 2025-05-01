package BOJ_1183;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		 
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		for (int i = 0; i < N; i++) {
	         st = new StringTokenizer(br.readLine());
	         input[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
 
		if(N%2==1) System.out.println(1);
		else System.out.println(Math.abs(input[N/2]-input[N/2-1])+1);
	}

}

