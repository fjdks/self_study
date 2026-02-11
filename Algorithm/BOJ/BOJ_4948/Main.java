package BOJ_4948;

import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] prime_num;
	
	static void isPrime(int n) {
		prime_num = new boolean[n + 1];
		Arrays.fill(prime_num, true);
		
		prime_num[0] = prime_num[1] = false;
		
		for (int i = 2; i < Math.sqrt(n); i++) {
			if(prime_num[i]) {
				for (int j = i * i; j <= n; j += i) {
					prime_num[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		int max = 0;
		while(true) {
			int cur = Integer.parseInt(br.readLine());
			if(cur == 0) break;
			nums.add(cur);
			max = Math.max(cur, max);
		}
		
		isPrime(max * 2);
		for (int i = 0; i < nums.size(); i++) {
			int cnt = 0;
			for (int j = (nums.get(i) + 1); j <= nums.get(i) * 2; j++) {
				if(prime_num[j]) cnt++;
			}
			System.out.println(cnt);
		}
	}

}
