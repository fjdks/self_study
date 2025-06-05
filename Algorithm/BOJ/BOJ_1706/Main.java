package BOJ_1706;

import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C;
	static char[][] puzzle;
	static ArrayList<String> words;
	
	static void add_words() {
		//가로 탐색
		for (int r = 0; r < R; r++) {
			String word = "";
			for (int c = 0; c < C; c++) {
				if(puzzle[r][c] != '#') {
					word += puzzle[r][c];
				} else {
					if(word.length() > 1) words.add(word);
					word = "";
				}
			}
			if(word.length() > 1) words.add(word);
			word = "";
		}
		
		//세로 탐색
		for (int c = 0; c < C; c++) {
			String word = "";
			for (int r = 0; r < R; r++) {
				if(puzzle[r][c] != '#') {
					word += puzzle[r][c];
				} else {
					if(word.length() > 1) words.add(word);
					word = "";
				}
			}
			if(word.length() > 1) words.add(word);
			word = "";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		puzzle = new char[R][C];
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				puzzle[r][c] = line.charAt(c);
			}
		}
		
		words = new ArrayList<>();
		
		add_words();
		
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i));
		}
		
		Collections.sort(words);
		System.out.println(words.get(0));
		
	}

}
