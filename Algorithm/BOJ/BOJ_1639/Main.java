package BOJ_1639;

import java.io.*;
import java.util.*;

public class Main {
	
	static boolean is_lucky(String substring) {
		int half_idx = (substring.length() / 2);
		int left = 0, right = 0;
		for (int i = 0; i < half_idx; i++) left += (substring.charAt(i) - '0');
		for (int i = half_idx; i < substring.length(); i++) right += (substring.charAt(i) - '0');
		if(left == right) return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int len = input.length();
		
		String sub = "";
		int max = 0;
		for (int start = 0; start < len - 1; start++) {
			for (int end = start + 1; end <= len; end++) {
				sub = "";
				for (int idx = start; idx < end; idx++) sub += input.charAt(idx);
				if(sub.length() < 2 || sub.length() % 2 != 0) continue;
				if(is_lucky(sub)) max = Math.max(max, sub.length());
			}
		}
		System.out.println(max);
	}

}
