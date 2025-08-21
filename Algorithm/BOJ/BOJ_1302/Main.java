package BOJ_1302;

import java.io.*;
import java.util.*;

public class Main {
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int max = 0;
		String best_seller = "";
		for (int i = 0; i < N; i++) {
			String book = br.readLine();
			map.putIfAbsent(book, 1);
			if(map.containsKey(book)) {
				int value = map.get(book);
				map.replace(book, value + 1);
				if(max < value + 1) {
					max = value + 1;
					best_seller = book;
				} else if(max == value + 1) {
					if(best_seller.compareTo(book) > 0) best_seller = book;
				}
			}
		}
		
		System.out.println(best_seller);
		
		
		
	}

}
