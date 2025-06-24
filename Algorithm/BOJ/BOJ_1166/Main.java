package BOJ_1166;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		double left = 0;
		double right = Math.min(L, Math.min(W, H));
		double mid;
		
		while(left < right) {
			mid = (left + right) / 2;
			
			if((long)(L/mid) * (long)(W/mid) * (long)(H/mid) < N) {
				if(right == mid) break;
				right = mid;
			} else {
				if(left == mid) break;
				left = mid;
			}
			
		}
		System.out.println(left);
		
	}

}
