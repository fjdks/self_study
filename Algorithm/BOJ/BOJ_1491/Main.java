package BOJ_1491;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, 0, -1, 0}; // 동, 북, 서, 남
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가로 (열 개수)
        int M = Integer.parseInt(st.nextToken()); // 세로 (행 개수)

        visited = new boolean[M][N]; // [세로][가로]

        int x = 0, y = 0; // 시작 (0,0)
        visited[y][x] = true;
        int dir = 0; // 동쪽부터 시작

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 앞으로 못 가면 왼쪽 회전
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[ny][nx]) {
                int ndir = (dir + 1) % 4;
                int tx = x + dx[ndir];
                int ty = y + dy[ndir];
                if (tx < 0 || tx >= N || ty < 0 || ty >= M || visited[ty][tx]) {
                    System.out.println(x + " " + y);
                    return;
                }
                dir = ndir;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
            visited[y][x] = true;
        }
    }
}

