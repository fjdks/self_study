package BOJ_1543;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String doc = br.readLine();
		String word = br.readLine();
		
		int doc_len = doc.length();
		int word_len = word.length();
				
		doc = doc.replace(word, "");
		System.out.println((doc_len - doc.length()) / word_len);
	
	}

}
