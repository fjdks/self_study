package BOJ_4779;

import java.io.*;
import java.util.Arrays;

public class Main {
	
	static int size;
	static char[] cantor;
	
	static void recursion(int div) {
		boolean toggle = true;
		for (int i = 0; i < size; i += div) {
			if((cantor[i] == '-') && !toggle) {
//				System.out.println(i);
//				System.out.println(div);
				for (int j = i; j < i + div; j++) cantor[j] = ' ';
			}
			toggle = !toggle;
		}
		if(div >= 3) recursion(div / 3);
	}

	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		String input = null;
		int N = 0;
		size = 0;
		while((input = br.readLine()) != null) {
			N = Integer.parseInt(input);
			size = (int) Math.pow(3, N);
			cantor = new char[size];
			Arrays.fill(cantor, '-');
			
			if(size >= 3) recursion(size / 3);
			sb = new StringBuilder();
			for (int i = 0; i < size; i++) sb.append(cantor[i]);
			System.out.println(sb);
		}
	}

}
