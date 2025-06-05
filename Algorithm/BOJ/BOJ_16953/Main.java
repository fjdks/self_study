package BOJ_16953;

import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		ans = 1;
		while(B != A) {
			if(B < A) {
				ans = -1;
				break;
			}
			
			String str = String.valueOf(B);
			if(str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
				ans = -1;
				break;
			}
			
			if(B % 2 == 0) {
				B = B / 2;
			} else {
				str = str.substring(0, str.length() - 1);
				B = Integer.parseInt(str);
			}
			
			ans++;
		}
		System.out.println(ans);
		
		br.close();
	}

}
