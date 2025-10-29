package BOJ_10610;

import java.io.*;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		char[] N = input.toCharArray();
		
		Arrays.sort(N);
		int sum = 0;
		for (int i = N.length - 1; i >= 0; i--) {
			int num = N[i] - '0';
			sum += num;
			sb.append(num);
		}
		
		if(sum % 3 != 0 || N[0] != '0') System.out.println(-1);
		else System.out.println(sb);
	}

}
