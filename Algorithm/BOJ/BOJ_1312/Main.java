package BOJ_1312;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int num = A % B;
		System.out.println(num);
		System.out.println("-------------");
		for (int i = 0; i < N - 1; i++) {
			num *= 10;
			num %= B;
			System.out.println(num);
		}
		System.out.println("---------");
		System.out.println(num);
		num *= 10;
		System.out.println(num);
		num /= B;
		System.out.println(num);
		
	}

}
