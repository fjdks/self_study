package BOJ_25192;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		Set<String> list = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String input = br. readLine();
			if(input.equals("ENTER")) {
				cnt += list.size();
				list.clear();
			} else list.add(input);
		}
		if(!list.isEmpty()) cnt += list.size();
		
		System.out.println(list.toString());
		System.out.println(cnt);
		
	}

}
