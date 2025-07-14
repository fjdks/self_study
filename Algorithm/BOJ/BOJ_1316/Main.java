package BOJ_1316;

import java.io.*;

public class Main {

	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			
			if(input.length() == 1) {
				cnt++;
				continue;
			} else {
				char cur = input.charAt(0);
				v = new boolean[27];
				v[cur - 'a'] = true;
				boolean flag = true;
				for (int j = 1; j < input.length(); j++) {
					if(input.charAt(j) != cur) {
						if(v[input.charAt(j) - 'a']) {
							flag = false;
							break;
						}
						else {
							v[input.charAt(j) - 'a'] = true;
						}
					}
					cur = input.charAt(j);
				}
				if(flag) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
