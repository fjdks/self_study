package BOJ_10814;

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<String>[] list; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[100001];
		for (int i = 0; i < 100001; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			list[index].add(st.nextToken());
		}
		
		for (int i = 0; i < 100001; i++) {
			if(list[i].isEmpty()) continue;
			for (int j = 0; j < list[i].size(); j++) {
				sb.append(i).append(' ').append(list[i].get(j));
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}
