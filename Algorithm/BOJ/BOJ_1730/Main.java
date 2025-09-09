package BOJ_1730;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cur_index, next_index;
    static char[][] board;
    
    static void print() {
        for (int i = 0; i < N; i++) {
            for (char c : board[i]) System.out.print(c);
            System.out.println();
        }
    }
    
    static int[] get_new_index(char c) {
        int[] ni = new int[2];
        switch (c) {
            case 'U': 
            	ni[0] = cur_index[0] - 1; 
            	ni[1] = cur_index[1]; 
            	break;
            case 'D': 
            	ni[0] = cur_index[0] + 1; 
            	ni[1] = cur_index[1]; 
            	break;
            case 'L': 
            	ni[0] = cur_index[0]; 
            	ni[1] = cur_index[1] - 1; 
            	break;
            case 'R': 
            	ni[0] = cur_index[0]; 
            	ni[1] = cur_index[1] + 1; 
            	break;
        }
        return ni;
    }
    
    static boolean is_in_range(int[] index) {
        return !(index[0] < 0 || index[0] >= N || index[1] < 0 || index[1] >= N);
    }
    
    static void mark(int r, int c, char pattern) {
        if (board[r][c] == '.') board[r][c] = pattern;
        else if (board[r][c] != pattern) board[r][c] = '+';
    }
    
    static void draw(char c) {
        char pattern = (c == 'U' || c == 'D') ? '|' : '-';
        mark(cur_index[0], cur_index[1], pattern);
        mark(next_index[0], next_index[1], pattern);
    }
    
    static void main_task(char c) {
        int[] ni = get_new_index(c);
        if (!is_in_range(ni)) return;
        next_index = ni;
        draw(c);
        cur_index = next_index;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        board = new char[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(board[i], '.');
        
        cur_index = new int[] {0, 0};
        for (int i = 0; i < input.length(); i++) {
            char command = input.charAt(i);
            main_task(command);
        }
        
        print();
    }
}
