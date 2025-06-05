package BOJ_2108;

import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		sb.append(Math.round(sum / N)).append('\n');
		// ------------------------
		int mid = arr[(N - 1) / 2];
		sb.append(mid).append('\n');
		//-------------------------
		int count = 0;
		int max = -1;
		int mode = arr[0];
		boolean check = false;
		for(int i = 0; i < N - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				count++;
			}else {
				count = 0;
			}
			
			if(max < count) {
				max = count;
				mode = arr[i];
				check = true;
			}else if(max == count && check == true) {
				mode = arr[i];
				check = false;
			}
		}
		sb.append(mode).append('\n');
		//--------------------------
		sb.append(arr[N-1] - arr[0]).append('\n');
		
		
		System.out.println(sb);
	}
}
