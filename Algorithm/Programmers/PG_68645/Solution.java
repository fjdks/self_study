import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][];

        for(int i = 0; i < n; i++) {
            snail[i] = new int[i + 1];
        }

        int[] di = {1, 0, -1};
        int[] dj = {0, 1, -1};

        int i = 0;
        int j = 0;
        int dir = 0;
        int num = 1;

        while(true) {
            snail[i][j] = num++;

            int ni = i + di[dir];
            int nj = j + dj[dir];

            if(ni < 0 || ni >= n ||
               nj < 0 || nj >= snail[ni].length ||
               snail[ni][nj] != 0) {

                dir = (dir + 1) % 3;

                ni = i + di[dir];
                nj = j + dj[dir];

                if(ni < 0 || ni >= n ||
                   nj < 0 || nj >= snail[ni].length ||
                   snail[ni][nj] != 0) {
                    break;
                }
            }

            i = ni;
            j = nj;
        }

        int[] answer = new int[n * (n + 1) / 2];

        int idx = 0;
        for(i = 0; i < n; i++) {
            for(j = 0; j < snail[i].length; j++) {
                answer[idx++] = snail[i][j];
            }
        }

        return answer;
    }
}