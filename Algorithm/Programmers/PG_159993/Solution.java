import java.util.*;

class Solution {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static int bfs(int[] start, char[][] map, char target) {
        int N = map.length;
        int M = map[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        q.add(new int[]{start[0], start[1], 0});
        v[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(map[cur[0]][cur[1]] == target) {
                return cur[2];
            }

            for(int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                if(map[ni][nj] == 'X' || v[ni][nj]) continue;

                v[ni][nj] = true;
                q.add(new int[]{ni, nj, cur[2] + 1});
            }
        }

        return -1;
    }

    public int solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();

        char[][] map = new char[N][M];

        int[] start = new int[2];
        int[] lever = new int[2];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);

                if(map[i][j] == 'S') {
                    start = new int[]{i, j};
                }

                if(map[i][j] == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }

        int toLever = bfs(start, map, 'L');

        if(toLever == -1) return -1;

        int toExit = bfs(lever, map, 'E');

        if(toExit == -1) return -1;

        return toLever + toExit;
    }
}