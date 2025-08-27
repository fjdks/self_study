package BOJ_1487;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] cus;
	static Set<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		cus = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cus[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			set.add(cus[i][0]);
		}
			
		ArrayList<Integer> arr = new ArrayList<Integer>(set);
		Collections.sort(arr, (o1, o2) -> o1 - o2);
//		System.out.println(arr.toString());
		int res = 0;
		int max_total = 0;
		for (int i = 0; i < arr.size(); i++) {
			int cur_total = 0;
			int cur_price = arr.get(i);
			for (int j = 0; j < cus.length; j++) {
				if(cur_price <= cus[j][0]) cur_total += cur_price - cus[j][1] > 0 ? cur_price - cus[j][1] : 0;
			}
			if(max_total < cur_total) {
				res = cur_price;
				max_total = cur_total;
			}
		}
		System.out.println(res);
	}

}
