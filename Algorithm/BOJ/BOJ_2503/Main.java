package BOJ_2503;

import java.io.*;
import java.util.*;

public class Main {
	
	static Set<Integer> set = new HashSet<Integer>();
	static boolean[] check = new boolean[1000];
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 123; i < 1000; i++){
            String str = Integer.toString(i);

            if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') continue;

            if(str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)) continue;
            check[i] = true;
        }
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int guess = Integer.parseInt(st.nextToken());
			int s_cnt = Integer.parseInt(st.nextToken());
			int b_cnt = Integer.parseInt(st.nextToken());
			
			for (int ans = 123; ans < 1000; ans++) {
				if(check[ans]) {
					int ns = 0;
					int nb = 0;
					for (int first = 0; first < 3; first++) {
						char guess_split = Integer.toString(guess).charAt(first);
						
						for (int second = 0; second < 3; second++) {
							char ans_split = Integer.toString(ans).charAt(second);
							if(guess_split == ans_split && first == second) ns++;
							else if(guess_split == ans_split && first != second) nb++;
						}
					}
					
					if(ns == s_cnt && nb == b_cnt) check[ans] = true;
					else check[ans] = false;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 123; i < 1000; i++) {
			if(check[i]) cnt++;
		}
		System.out.println(cnt);
	}

}
