package BOJ_1049;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int min_bundle = 1000;
		int min_each = 1000;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			min_bundle = Math.min(Integer.parseInt(st.nextToken()), min_bundle);
			min_each = Math.min(Integer.parseInt(st.nextToken()), min_each);
		}
		
		int limit = 6;
		for (int i = 1; i <= 6; i++) {
			if(min_bundle < min_each * i) {
				limit = i;
				break;
			}
		}
		
		int price = 0;

		price += (min_bundle < (min_each * 6)) ? (N / 6) * min_bundle : (N / 6) * (min_each * 6);
		N %= 6;
		
		price += (N >= limit) ? min_bundle : (min_each * N);
		
		System.out.println(price);
	}

}

