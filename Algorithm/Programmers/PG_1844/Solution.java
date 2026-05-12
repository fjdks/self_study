import java.util.*;

class Solution {
    static int[] di = new int[] {-1, 0, 1, 0};
    static int[] dj = new int[] {0, 1, 0, -1};
    
    static int bfs(int[] end, int[][] map, boolean[][] v) {
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        v[0][0] = true;
        pq.add(new int[]{0, 0, 1});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[0] == end[0] && cur[1] == end[1]) return cur[2];
            
            for(int d = 0; d < 4; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(ni < 0 || map.length <= ni || nj < 0 || map[0].length <= nj || map[ni][nj] == 0 || v[ni][nj]) continue;
                v[ni][nj] = true;
                pq.add(new int[] {ni, nj, cur[2] + 1});
                
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        int answer = bfs(new int[] {maps.length - 1, maps[0].length - 1}, maps, new boolean[maps.length][maps[0].length]);
        
        
        return answer;
    }
}