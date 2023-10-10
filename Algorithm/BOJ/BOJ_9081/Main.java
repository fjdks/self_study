package BOJ_9081;

import java.io.*;
import java.util.*;

public class Main {
	
	static String solution(String S) {
		StringBuilder sb = new StringBuilder();
		char[] arr = S.toCharArray();
		int idx1 = -1;
		for (int i = arr.length - 1; i > 0 ; i--) {
			// 뒤에서부터 처음으로 감소하는 index를 찾음
			if(arr[i] > arr[i - 1]) {
				idx1 = i - 1;
				break;
			}
		}
		
		// 가장 마지막 단어임(사전순으로 다음에 오는 단어가 없음)
		if(idx1 == -1) return S;
		
		int idx2 = 0;
		for (int i = arr.length - 1; i > idx1; i--) {
			// 다시 뒤에서부터 idx1 까지 범위 중 idx1 보다 큰 원소 중 가장 처음으로 만나는 원소를 찾음
			if(arr[i] > arr[idx1]) {
				idx2 = i;
				break;
			}
		}
		// idx1의 원소와 idx2의 원소를 swap
		char temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
		
		// idx1 위치의 원소부터 끝까지 오름차순으로 정렬
		Arrays.sort(arr, idx1 + 1, arr.length);
		for(char c : arr) sb.append(c);
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String word = br.readLine();
			System.out.println(solution(word));
		}
	}

}
