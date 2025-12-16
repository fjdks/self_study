package BOJ_11478;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		Set<String> set = new HashSet<String>();
		
		int len = 1;
		while(len <= S.length()) {
			for (int i = 0; i < S.length() - len + 1; i++) set.add(S.substring(i, i + len));
			len++;
		}
		System.out.println(set.toString());
		
	}

}
