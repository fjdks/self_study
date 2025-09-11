package BOJ_1755;

import java.io.*;
import java.util.*;

public class Main {
	
	static String[] alpha = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static PriorityQueue<Myformat> num_to_alpha = new PriorityQueue<Myformat>();
	
	static String convert(String num) {
		String str = "";
		for (int i = 0; i < num.length(); i++) {
			str += alpha[num.charAt(i) - '0'];
		}
		return str;
	}
	
	static class Myformat implements Comparable<Myformat> {
		String std;
		String cnv;
		
		public Myformat(String std, String cnv) {
			this.std = std;
			this.cnv = cnv;
		}
		
		@Override
		public int compareTo(Myformat o) {
			return this.cnv.compareTo(o.cnv);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M - N + 1; i++) {
			num_to_alpha.add(new Myformat(Integer.toString(N + i), convert(Integer.toString(N + i))));
		}
		
		int size = num_to_alpha.size();
		int cnt = 1;
		for (int i = 0; i < size; i++) {
			Myformat mf = num_to_alpha.poll();
			System.out.print(mf.std + " ");
			if(cnt++ == 10) {
				System.out.println();
				cnt = 1;
			}
				
		}
		
	}

}
