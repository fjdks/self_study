package BOJ_1065;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	
	static int cnt;
	static ArrayList<Integer> arr;
	
	static void count() {
		if (arr.size() <= 2) {
			cnt++;
		}
		else {
			boolean flag = true;
//			System.out.println(arr.toString());
			int gap = arr.get(0) - arr.get(1);
//			System.out.println(gap);
			for (int i = 0; i < arr.size() - 1; i++) {
				if(arr.get(i) - arr.get(i + 1) != gap) {
					flag = false;
					break;
				}
			}
			cnt = flag ? cnt + 1 : cnt;
//			if(flag) {
//				cnt++;
//				System.out.println(gap);
//				System.out.println(arr.toString());
//			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int size = input.length();
		
		int N = Integer.parseInt(input);
		int cur = 1;
		cnt = 0;
		while(cur <= N) {
			arr = new ArrayList<Integer>();
			String s = cur + "";
			int len = s.length();
			int p = 0;
			while(p < len) {
				arr.add(s.charAt(p++) - '0');
			}
//			System.out.println(arr.toString());
			count();
			cur++;
		}
		System.out.println(cnt);
	}

}
