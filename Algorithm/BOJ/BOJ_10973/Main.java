package BOJ_10973;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] std_arr;
	static StringBuilder sb = new StringBuilder();
	static void sort(ArrayList<Integer> list, int new_int) {
		int[] new_arr = new int[list.size() + 1];
		int max = 0;
		int idx = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) < new_int && max < list.get(i)) {
				max = list.get(i);
				idx = i;
			}
		}
//		System.out.println(max);
//		System.out.println(list.toString());
		list.remove(idx);
		list.add(new_int);
		Collections.sort(list, Collections.reverseOrder());
//		System.out.println(list.toString());
		new_arr[0] = max;
		for (int i = 0; i < list.size(); i++) new_arr[i + 1] = list.get(i);
		
		for (int i = 0; i < std_arr.length - new_arr.length; i++) sb.append(std_arr[i]).append(" ");
		for (int i = 0; i < new_arr.length; i++) sb.append(new_arr[i]).append(" ");
		
	}
	
	static void pre_perm(int[] arr) {
		int len = arr.length;
		int idx = len;
		int min = arr[idx - 1];
		ArrayList<Integer> temp = new ArrayList<>();
		while(idx-- > 0) {
			if(temp.isEmpty()) {
				temp.add(arr[idx]);
				continue;
			}
			
			if(arr[idx] > min) {
				sort(temp, arr[idx]);
				break;
			}
			else {
				temp.add(arr[idx]);
				min = Math.min(arr[idx], min);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		std_arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) std_arr[i] = Integer.parseInt(st.nextToken());
		
		pre_perm(std_arr);
		
		System.out.println(sb.length() == 0 ? -1 : sb);
	}

}
