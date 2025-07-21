package BOJ_1059;

import java.io.*;
import java.util.*;

public class Main {
	
	static int L, n, ans;
	static int[] S, sel;
	static boolean[] v;
	
	static void comb(int[] r, int depth, int start) {
		if(depth == 2) {
			if(sel[0] <= n && n <= sel[1]) ans++;
			return;
		}
		for (int i = start; i < r.length; i++) {
			sel[depth] = r[i];
			comb(r, depth + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		L = Integer.parseInt(br.readLine());
		S = new int[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) S[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(S);
		
		n = Integer.parseInt(br.readLine());

		ans = -1;
		int left = 0;
		int right = S[L - 1];
		for (int i = 0; i < L; i++) {
			if(S[i] == n) {
				ans = 0;
				break;
			} else if(left == 0 && right == S[L - 1] && S[i] > n) {
				left = i > 0 ? S[i - 1] : 0;
				right = S[i];
			}
		}
		
		if(ans == 0) System.out.println(ans);
		else {
			ans = 0;
			int[] range = new int[right - left - 1];
			for (int i = 0; i < right - left - 1; i++) range[i] = left + i + 1;
			sel = new int[2];
			v = new boolean[right];
			
			comb(range, 0, 0);
			System.out.println(ans);
		}
		
		
	}

}
