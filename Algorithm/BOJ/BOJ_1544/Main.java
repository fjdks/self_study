package BOJ_1544;

import java.io.*;
import java.util.*;

public class Main {
	
	static String[] words;
	static boolean[] check;
	static ArrayList<Integer> idx;
	
	static boolean is_same_word(String std, String cmp) {
		if(std.length() == cmp.length()) {
			String doubled = std + std;
			if(doubled.contains(cmp)) return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		 
		words = new String[N];
		for (int i = 0; i < N; i++) words[i] = br.readLine();
		
		check = new boolean[N];
		int res = 0;
		for (int i = 0; i < N; i++) {
			if(check[i]) continue;
			res++;
			for (int j = i + 1; j < N; j++) {
				if(is_same_word(words[i], words[j])) check[j] = true;
			}
			
		}
		System.out.println(res);
	}

}
