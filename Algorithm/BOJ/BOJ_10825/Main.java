package BOJ_10825;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static String[][] list;
	
	static void step_1() {
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		list = new String[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) list[i][j] = st.nextToken();
		}
		
		Arrays.sort(list, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				int kor1 = Integer.parseInt(o1[1]);
				int kor2 = Integer.parseInt(o2[1]);
				
				int eng1 = Integer.parseInt(o1[2]);
				int eng2 = Integer.parseInt(o2[2]);
				
				int math1 = Integer.parseInt(o1[3]);
				int math2 = Integer.parseInt(o2[3]);
				
				String name1 = o1[0];
				String name2 = o2[0];
				return kor1 != kor2 ? kor2 - kor1 : (eng1 != eng2 ? eng1 - eng2 : (math1 != math2 ? math2 - math1 : (name1.compareTo(name2))));
			}
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(list[i][0]);
		}
		
	}

}
