package BOJ_2847;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		for (int i = 0; i < N; i++) scores[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for (int i = N - 1; i > 0; i--) {
			while(true) {
				if(scores[i] <= scores[i - 1]) {
					scores[i - 1]--;
					cnt++;
				}
				else break;
			}
		}
		System.out.println(cnt);
	}

}
