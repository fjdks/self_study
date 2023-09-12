package BOJ_1269;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static HashSet<Integer> A = new HashSet<>();
	static HashSet<Integer> B = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		
		int ans = 0;
		for(int num : A) if(!B.contains(num)) ans += 1;
		for(int num : B) if(!A.contains(num)) ans += 1;
		
		System.out.println(ans);
	}

}
