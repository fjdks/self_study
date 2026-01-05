package BOJ_1431;

import java.io.*;
import java.util.*;

public class Main {
	
	static int sum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if('0' <= s.charAt(i) && s.charAt(i) <= '9') sum += s.charAt(i) - '0';
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] numbers = new String[N];
		for (int n = 0; n < N; n++) {
			numbers[n] = br.readLine();
		}
		
		Arrays.sort(numbers, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) return o1.length() - o2.length();
				else {
					int sum_a = sum(o1);
					int sum_b = sum(o2);
					if(sum_a > sum_b) return 1;
					else if(sum_a < sum_b) return -1;
					else return o1.compareTo(o2);
				}
			}
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(numbers[i]);
		}
	}

}
