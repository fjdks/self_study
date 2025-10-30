package BOJ_11656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int len = S.length();

		String[] arr = new String[len];
		for (int i = 0; i < len; i++) {
			String ns = "";
			for (int j = i; j < len; j++) ns += S.charAt(j);
			arr[i] = ns;
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}
	}

}
