package BOJ_1270;

import java.io.*;
import java.util.*;

public class Main {

	static int n, T;
	static HashMap<Long, Integer> army = new HashMap<>();;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < T; j++) {
				long cur = Long.parseLong(st.nextToken());
				
				if(army.containsKey(cur)) {
					army.replace(cur, army.get(cur) + 1);
				} else {
					army.put(cur, 1);
				}
			}
			
			Long num = 0L;
			int max = 0;
			for(long key : army.keySet()) {
				int value = army.get(key);
				if(max < value) {
					max = value;
					num = key;
				}
			}
			if((T / 2) < max) System.out.println(num);
			else System.out.println("SYJKGW");
			army.clear();
		}
	}

}
