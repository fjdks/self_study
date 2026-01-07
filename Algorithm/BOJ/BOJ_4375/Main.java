package BOJ_4375;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		while((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			int start = 1;
			int cnt = 1;
			while(start % n != 0) {
				start = (start * 10 + 1) % n;
				cnt++;
			}
			System.out.println(cnt);
		}
	}

}
