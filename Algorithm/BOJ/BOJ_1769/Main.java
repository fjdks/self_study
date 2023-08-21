package BOJ_1769;

import java.io.*;

public class Main {
	
	static String XtoY(String X) {
		int Y = 0;
		for (int i = 0; i < X.length(); i++) {
			Y += (X.charAt(i) - '0');
		}
		String Y_string = Integer.toString(Y);
		return Y_string;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String X = br.readLine();
		
		String Y = X;
		int cnt = 0;
		while(Y.length() > 1) {
			Y = XtoY(Y);
			cnt++;
		}
		int num = Integer.parseInt(Y);
		System.out.println(cnt);
		System.out.println(num % 3 == 0? "YES" : "NO");
		
	}

}
