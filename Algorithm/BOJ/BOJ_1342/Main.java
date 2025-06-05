package BOJ_1342;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int cnt;
	static int[] alphabet = new int[27];

	static void dfs(int depth, char pre, int len) {
		if(depth == len) {
			cnt++;
			return;
		}
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == 0) continue;
			if(pre != (char) (i + 'a')) {
				alphabet[i]--;
				dfs(depth + 1, (char)(i + 'a'), len);
				alphabet[i]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		for (int i = 0; i < S.length(); i++) {
			alphabet[S.charAt(i) - 'a']++;
		}
		
		dfs(0, ' ', S.length());
		System.out.println(cnt);
	}

}
