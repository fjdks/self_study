package BOJ_1748;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int quo = input.length();
		int N = Integer.parseInt(input);
		
		int digits = 1;
		int ans = 0;
		for (int i = 0; i < quo - 1; i++) {
			ans += digits * 9 * Math.pow(10, digits - 1);
			digits++;
		}
		
		ans += (N - Math.pow(10, digits - 1) + 1) * digits;
		System.out.println(ans);
		
	}

}
