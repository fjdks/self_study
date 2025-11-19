package BOJ_11652;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		 
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		for (int i = 0; i < N; i++) {
			Long card = Long.parseLong(br.readLine());
			if(map.containsKey(card)) map.replace(card, map.get(card), map.get(card) + 1);
			else map.put(card, 1);
		}
		
		List<Long> set = new ArrayList<>(map.keySet());
		int max = -1;
		Long num = (long) 0;
		for (int i = 0; i < map.size(); i++) {
			Long card = set.get(i);
			if(map.get(card) > max) {
				max = map.get(card);
				num = card;
			}
		}
		System.out.println(num);
	}

}
