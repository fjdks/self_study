package BOJ_14719;

import java.io.*;
import java.util.*;

public class Main {
	
	static int ans;
	static int[] block;
	
	static int getArea(int start, int end) {
		int H = Math.min(block[start], block[end]);
		int res = (end - start - 1) * H;
		for (int i = start + 1; i < end; i++) res -= block[i];
		if(res < 0) res = 0;
		
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		block = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int idx = -1;
		for (int i = 0; i < W; i++) {
			if(block[i] != 0) {
				idx = i;
				break;
			}
		}
		
		ans = 0;
		int cur = idx;
		while(idx < W - 1) {
			cur++;
			if(block[cur] < block[idx]) {
				if(idx - cur == 1) idx = cur;
				else if(cur >= W - 1) {
					int h = 0;
					for (int i = idx + 1; i < W; i++) {
						if(block[i] > h) {
							cur = i;
							h = block[i];
						}
					}
					ans += getArea(idx, cur);
					idx = cur;
				}
			}
			if(block[cur] >= block[idx]) {
				ans += getArea(idx, cur);
				idx = cur;
			}
		}
		System.out.println(ans);
	}

}
