package BOJ_10816;

import java.io.*;
import java.util.*;

public class Main {

	static int[] cards, nums;
	static LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
		
		for (int i = 0; i < N; i++) {
			if(!hm.containsKey(cards[i])) {
				hm.put(cards[i], 1);
			} else {
				hm.put(cards[i], hm.get(cards[i]) + 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			if(hm.containsKey(nums[i])) sb.append(hm.get(nums[i])).append(' ');
			else sb.append(0).append(' ');
		}
		System.out.println(sb);
		
		
	}

}
