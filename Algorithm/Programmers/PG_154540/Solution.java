import java.util.*;

class Solution {
    static int[] di = new int[] {-1, 0, 1, 0};
    static int[] dj = new int[] {0, 1, 0, -1};
    static int N, M, sum;
    static boolean[][] v;
    static char[][] map;
    static PriorityQueue<Integer> food;
    
    static void dfs(int i, int j) {
        v[i][j] = true;
        sum += map[i][j] - '0';
        for(int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if(0 <= ni && ni < N && 0 <= nj && nj < M && !v[ni][nj] && map[ni][nj] != 'X') {
                dfs(ni, nj);
            }
        }
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        v = new boolean[N][M];
        food = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!v[i][j] && map[i][j] != 'X') {
                    sum = 0;
                    dfs(i, j);
                    food.add(sum);
                }
            }
        }
        answer = new int[food.size()];
        int size = food.size();
        if(size == 0) answer = new int[] {-1};
        else {
            for(int i = 0; i < size; i++) answer[i] = food.poll();    
        }
        
        
        return answer;
    }
}