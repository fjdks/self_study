package BOJ_1182;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S, ans;
	static int[] nums;
	static boolean[] v;
	static ArrayList<Integer> selected = new ArrayList<>();
	
	static void check_sum() {
		int sum = 0;
		
		if(selected.isEmpty()) return;
		
		for (int i = 0; i < selected.size(); i++) {
			sum += selected.get(i);
		}
		
		if(sum == S) ans++;
	}
	
	static void sub(int cnt) {
		if(cnt ==  N) {
			for (int i = 0; i < N; i++) {
				if(v[i]) selected.add(nums[i]);
			}
			
			check_sum();
			selected.clear();
			return;
		}
		
		v[cnt] = true;
		sub(cnt + 1);
		
		v[cnt] = false;
		sub(cnt + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		
		sub(0);
		System.out.println(ans);
		
	}

}
