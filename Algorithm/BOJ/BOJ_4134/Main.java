package BOJ_4134;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			Long N = Long.parseLong(br.readLine());
			if(N < 2) N = (long)2;
			
			boolean flag = false;
			while(true) {
				for (int i = 2; i <= Math.sqrt(N); i++) {
					if((N % i) == 0) {
						flag = true;
						break;
					}
				}
				if(flag) {
					flag = false;
					N++;
				}
				else {
					System.out.println(N);
					break;
				}
			}
		}
	}

}
