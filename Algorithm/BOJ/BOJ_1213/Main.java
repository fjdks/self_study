package BOJ_1213;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[] alphabet = new int[26];
	static int oddcheck;
	static String input;
	static char mid;
	
	static String main_task() {
		StringBuilder sb = new StringBuilder();
		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();
		
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] != 0) {
				for (int j = 0; j < alphabet[i]/2; j++) {
					left.append((char)(i + 'A'));
				}
			}
		}
		sb.append(left);
		right = left.reverse();
		
		if(input.length() % 2 == 0) sb = sb.append(right);
		else sb = sb.append(mid).append(right);
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		
		for (int i = 0; i < input.length(); i++) {
			alphabet[input.charAt(i) - 65]++;
		}
		
		oddcheck = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] % 2 == 1) {
				oddcheck++;
				mid = (char)(i + 'A');
			}
		}
		
		if((input.length() % 2 == 0) && oddcheck > 0) {
			System.out.println("I'm Sorry Hansoo");
		} else if((input.length() % 2 == 1) && oddcheck > 1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			System.out.println(main_task());
		}
		
		
		
	}

}
