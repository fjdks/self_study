package BOJ_10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int cur, ans;
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		s.clear();
		for (int k = 0; k < K; k++) {
			cur = Integer.parseInt(br.readLine());
			if(cur == 0) {
				if(s.isEmpty()) continue;
				else s.pop();
			} else {
				s.add(cur);
			}
		}
		ans = 0;
		while(!s.isEmpty()) {
			ans += s.pop();
		}
		System.out.println(ans);
	}

}
