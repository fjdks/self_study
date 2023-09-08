package BOJ_10815;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] cards;
	static LinkedHashSet<Integer> hs = new LinkedHashSet<>();

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
			hs.add(cards[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if(hs.contains(Integer.parseInt(st.nextToken()))) sb.append(1);
			else sb.append(0);
			sb.append(' ');
		}
		
		System.out.println(sb);
		
	}

}
