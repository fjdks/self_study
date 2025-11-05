package BOJ_3986;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int cnt;
	
	static void check(String input) {
		
		int len = input.length();
		if(len % 2 == 1) return;
		boolean flag = false;
		while(true) {
			if(len == 0 || flag) break;
			len = input.length();
//			System.out.println(input);
			for (int i = 0; i < len - 1; i++) {
				if(input.charAt(i) == input.charAt(i + 1)) {
					if(len == 2) {
						input = "";
						cnt++;
					}
					else {
//						System.out.println(i);
						input = input.substring(0, i) + input.substring(i + 2, len);
//						System.out.println(input);
						break;
					}
				}
				if(i >= len - 2) flag = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cnt = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			check(input);
		}
		System.out.println(cnt);
	}

}
