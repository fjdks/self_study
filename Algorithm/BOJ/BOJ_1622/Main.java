package BOJ_1622;

import java.io.*;

public class Main {
	
	static int[] letters_std;
	static int[] letters_cmp;
	static int[] letters_ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String a = br.readLine();
			if(a == null) break;
			String b = br.readLine();
			
			String std_str = Math.min(a.length(), b.length()) == a.length() ? a : b;
			String cmp_str = Math.min(a.length(), b.length()) == a.length() ? b : a;
			
			letters_std = new int[26];
			letters_cmp = new int[26];
			letters_ans = new int[26];
			
			for (int i = 0; i < std_str.length(); i++) letters_std[std_str.charAt(i) - 'a']++;
			for (int i = 0; i < cmp_str.length(); i++) letters_cmp[cmp_str.charAt(i) - 'a']++;
			
			for (int i = 0; i < 26; i++) {
				if (letters_std[i] != 0) {
					int len = letters_std[i];
					for (int j = 0; j < len; j++) {
						if(letters_cmp[i] != 0) {
							letters_std[i]--;
							letters_cmp[i]--;
							letters_ans[i]++;
						}
					}
				}
			}

			String ans = "";
			for (int i = 0; i < 26; i++) {
				if(letters_ans[i] != 0) {
					for (int j = 0; j < letters_ans[i]; j++) {
						ans += (char)(i + 97);
					}
				}
			}
			System.out.println(ans);
		}
	}

}
