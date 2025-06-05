package BOJ_10972;

import java.io.*;
import java.util.*;

public class Main {
	
	static boolean next_perm(int arr[]) {
		int i = arr.length - 1;
		
		while(i > 0 && arr[i - 1] >= arr[i]) {
			i -= 1;
		}
		
		if(i <= 0) return false;
		
		int j = arr.length - 1;
		
		while(arr[i - 1] >= arr[j]) {
			j -= 1;
		}
		
		int temp = arr[j];
		arr[j] = arr[i - 1];
		arr[i - 1] = temp;
		
		j = arr.length - 1;
		
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i += 1;
			j -= 1;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(next_perm(arr)) {
			for(int val: arr) sb.append(val).append(" ");
		} else sb.append("-1");
		
		System.out.println(sb);
	}

}
