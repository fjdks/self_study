package BOJ_1343;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String board = br.readLine();
		String ans = "";
		int X_cnt = 0;
		for (int i = 0; i < board.length(); i++) {
			char cur = board.charAt(i);
			
			if(cur == 'X') {
				X_cnt++;
			} else if(cur == '.'){
				if(X_cnt % 2 == 1) {
					ans = "-1";
					break;
				} else {
					int quo4 = X_cnt / 4;
					int mod4 = X_cnt % 4;
					
					for (int j = 0; j < quo4; j++) ans += "AAAA";
					
					int quo2 = mod4 / 2;
					for (int j = 0; j < quo2; j++) ans += "BB";
					
				}
				
				ans += (cur == '.' ? "." : "");
				X_cnt = 0;
			}
		}
		
		if(X_cnt % 2 == 1) {
			ans = "-1";
		} else {
			int quo4 = X_cnt / 4;
			int mod4 = X_cnt % 4;
			
			for (int j = 0; j < quo4; j++) ans += "AAAA";
			
			int quo2 = mod4 / 2;
			for (int j = 0; j < quo2; j++) ans += "BB";
			
		}
		
		System.out.println(ans);
	}

}
