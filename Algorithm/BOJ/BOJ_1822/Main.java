package BOJ_1822;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nA = Integer.parseInt(st.nextToken());
		int nB = Integer.parseInt(st.nextToken());
		int[] A = new int[nA];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nA; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		
		st = new StringTokenizer(br.readLine());
		Set<Integer> B = new HashSet<Integer>();
		for (int i = 0; i < nB; i++) B.add(Integer.parseInt(st.nextToken()));
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nA; i++) {
			if(!B.contains(A[i])) {
				sb.append(A[i]).append(" ");
				cnt++;
			}
		}
		
		
		if(sb.length() == 0) System.out.println(0);
		else {
			System.out.println(cnt);
			System.out.println(sb);
		}
		
	}

}
