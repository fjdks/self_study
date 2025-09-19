package BOJ_1862;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		String conv = input + "";
		int len = conv.length();
		int res = 0;
		for (int i = 0; i < len; i++) {
			int digit = input % 10;
			input /= 10;
			
			if(digit > 4) res += (digit - 1) * (Math.pow(9, i));
			else res += digit * Math.pow(9, i);
		}
		System.out.println(res);

		
		
	}

}
