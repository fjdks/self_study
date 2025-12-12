package BOJ_9375;

import java.io.*;
import java.util.*;

public class Main {
	
	static Map<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			map.clear();
			int N = Integer.parseInt(br.readLine());
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				String v = st.nextToken();
				String k = st.nextToken();
				if(!map.containsKey(k)) map.put(k, 1);
				else map.put(k, map.get(k) + 1);
			}
			int sum = 1;
			for (String key : map.keySet()) sum *= (map.get(key) + 1);
			System.out.println(sum - 1);
		}
	}

}
