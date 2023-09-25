package BOJ_11279;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	static PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(max_heap.isEmpty()) System.out.println(0);
				else System.out.println(max_heap.poll());
			}
			else max_heap.add(num);
		}
	}

}
