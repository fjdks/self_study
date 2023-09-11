package BOJ_1072;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static int cur_rate, X, Y;
	
	static int getWinRate(int X, int Y) {
		int winRate = (int) ((long)Y * 100 / X);
		return winRate;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		cur_rate = getWinRate(X, Y);
		
		int ans = -1;
		int left = 0;
		int right = (int)1e9;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(getWinRate(X + mid, Y + mid) != cur_rate) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
		
	}

}
