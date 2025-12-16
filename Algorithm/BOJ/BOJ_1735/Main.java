package BOJ_1735;

import java.io.*;
import java.util.*;

public class Main {
	
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int A1, B1, A2, B2;
		
		st = new StringTokenizer(br.readLine());
		A1 = Integer.parseInt(st.nextToken());
		B1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		A2 = Integer.parseInt(st.nextToken());
		B2 = Integer.parseInt(st.nextToken());
		
		int nume = (A1 * B2) + (A2 * B1);
		int deno = (B1 * B2);
		
		int g = gcd(nume, deno);
		System.out.println((nume / g) + " " + (deno / g));
		
		
		
	}

}
