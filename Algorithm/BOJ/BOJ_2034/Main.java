package BOJ_2034;

import java.io.*;
import java.util.*;

public class Main {

	static int[] scale = new int[] {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1};
	static int[] white_key = new int[] {9, 11, 0, 2, 4, 5, 7};
	
	static char intToChar(int input) {
		char output = 0;
		for (int i = 0; i < white_key.length; i++) {
			if(input == white_key[i]) output = (char)(i + 65);
		}
		return output;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] sheet = new int[n];
		for (int i = 0; i < n; i++) sheet[i] = Integer.parseInt(br.readLine());

		ArrayList<int[]> arr = new ArrayList<int[]>();
		
		int idx = 0;
		for (int start : white_key) {
			idx = start;
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				idx = (idx + sheet[i] + 24) % 12;
				if(scale[idx] == 0) {
					flag = false;
					break;
				}
			}
			if(flag) arr.add(new int[] {start, idx});
		}

		for(int[] i : arr) sb.append(intToChar(i[0])).append(" ").append(intToChar(i[1])).append("\n");
		
		System.out.println(sb);

	}

}
