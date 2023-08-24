package BOJ_1475;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		set = new int[10];
		
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			int num = line.charAt(i) - '0';
			set[num]++;
		}
		
		set[9] = (set[6] + set[9]) % 2 == 1? (set[6] + set[9] + 1) / 2 : (set[6] + set[9]) / 2;
		set[6] = 0;
		
		int max = 0;
		for (int i = 0; i < 10; i++) {
			max = Math.max(max, set[i]);
		}
		System.out.println(max);
		
	}

}
