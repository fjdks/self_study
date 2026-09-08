import java.util.*;

class Solution {
    static int[] di = new int[] {-1, 0, 1, 0};
    static int[] dj = new int[] {0, 1, 0, -1};
    
    static int bfs(int[] start, char[][] board) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[board.length][board[0].length];
        int N = board.length;
        int M = board[0].length;
        
        v[start[0]][start[1]] = true;
        q.add(new int[]{start[0], start[1], 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ci = cur[0];
                int cj = cur[1];
                while(true) {
                    int ni = ci + di[d];
                    int nj = cj + dj[d];
                    if(ni < 0 || N <= ni || nj < 0 || M <= nj || board[ni][nj] == 'D') break;
                    else {
                        ci = ni;
                        cj = nj;
                    }
                }
                
                if(board[ci][cj] == 'G') return cur[2] + 1;
                if(v[ci][cj]) continue;
                q.add(new int[] {ci, cj, cur[2] + 1});
                v[ci][cj] = true;
                
            }
        }
        return -1;
    }
    
    public int solution(String[] input) {
        int answer = 0;
        char[][] board = new char[input.length][input[0].length()];
        int[] start = new int[2];
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[i].length(); j++) {
                board[i][j] = input[i].charAt(j);
                if(input[i].charAt(j) == 'R') start = new int[]{i, j};
            }
        }
        
        answer = bfs(start, board);
                
        
        return answer;
    }
}