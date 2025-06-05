package BOJ_2751;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(numbers);
		
		for (int i = 0; i < N; i++) {
			sb.append(numbers.get(i)).append('\n');
		}
		
		System.out.println(sb);
	}
}
