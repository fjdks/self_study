package BOJ_17219;

import java.io.*;
import java.util.*;

public class Main {
	static String address, password;
	static HashMap<String,String> adds = new HashMap<String,String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			address = st.nextToken();
			password = st.nextToken();
			adds.put(address, password);
		}
		
		for (int i = 0; i < M; i++) {
			System.out.println(adds.get(br.readLine()));
		}
	}
}
