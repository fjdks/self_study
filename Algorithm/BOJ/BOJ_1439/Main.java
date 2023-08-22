package BOJ_1439;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		int min = 0;
		
		int cnt = 0;
		boolean flag = false;
		for (int j = 0; j < S.length(); j++) {
			if(S.charAt(j) == '0') {
				if(flag) continue;
				else {
					flag = true;
					cnt++;
				}
			} else {
				flag = false;
			}
		}
		
		min = cnt;
		
		cnt = 0;
		flag = false;
		for (int j = 0; j < S.length(); j++) {
			if(S.charAt(j) == '1') {
				if(flag) continue;
				else {
					flag = true;
					cnt++;
				}
			} else {
				flag = false;
			}
		}
		
		System.out.println(Math.min(min, cnt));
		
	}

}
