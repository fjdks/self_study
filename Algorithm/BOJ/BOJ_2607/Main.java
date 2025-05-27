package BOJ_2607;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] word = new int[26];
	static int[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String target = br.readLine();
		for (int i = 0; i < target.length(); i++) {
			word[target.charAt(i) - 'A']++;
		}
		
		int res = 0;
		for (int i = 0; i < N - 1; i++) {
			String compare = br.readLine();
			if(Math.abs(target.length() - compare.length()) > 1) continue;
			
			int cnt = 0;
			check = word.clone();
			for (int j = 0; j < compare.length(); j++) {
				int idx = compare.charAt(j) - 'A';
				if(check[idx] > 0) {
					cnt++;
					check[idx]--;
				}
			}
			
			if(target.length() == compare.length()) {
				if(cnt == target.length()) res++;
				else if(cnt == target.length() - 1) res++;
			}
			else if(target.length() - 1 == compare.length()) {
				if(cnt == compare.length()) res++;
			}
			else if(target.length() + 1 == compare.length()) {
				if(cnt == target.length()) res++;
			}
		}
		
		System.out.println(res);
		
	}

}
