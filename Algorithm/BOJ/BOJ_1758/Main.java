package BOJ_1758;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] input = new Integer[N];
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(input, Collections.reverseOrder());
		
		long sum = 0;
		for (int i = 0; i < N; i++) {
			int tip = input[i] - i;
			if(tip < 0) break;
			sum += tip;
		}
		System.out.println(sum);
	}

}
