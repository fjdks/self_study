package BOJ_1235;

import java.io.*;
import java.util.*;

public class Main {
	
	static Set<String> set = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] students = new String[N];
		for (int i = 0; i < N; i++) students[i] = br.readLine();
		int len = students[0].length();
		
		int k = 1;
		while(true) {
			set.clear();
			for (int i = 0; i < N; i++) {
				String s = "";
				for (int j = len - k; j < len; j++) {
					s += students[i].charAt(j);
				}
				set.add(s);
			}
			if(set.size() == N) break;
			k++;
		}
		System.out.println(k);
	}

}
