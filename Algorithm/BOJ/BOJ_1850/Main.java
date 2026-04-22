package BOJ_1850;

import java.io.*;
import java.util.*;

public class Main {

	static long GCD(long a, long b) {
		if(b == 0) return a;
		else return GCD(b, a % b);
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		
		Long gcd = GCD(A, B);
		String answer = "";
		for(int i = 1; i <= gcd; i++) answer += "1";
		System.out.println(answer.toString());
		
	}

}
