package BOJ_1629;

import java.io.*;
import java.util.*;

public class Main {
	
	static long pow(Long a, Long b, Long c) {
		if(b == 1) return (int)(a % c);
		Long temp = pow(a, b/2, c);
		if(b % 2 == 1) return ((temp * temp % c) * a) % c;
		return temp * temp % c;
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B, C));
		
	}
}
