import java.util.*;

class Solution {
    static int[] cost;
    static ArrayList<Integer>[] map;
    static boolean[] v;
    
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();      
        q.add(start);
        cost[start] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            int len = map[cur].size();
            for(int i = 0; i < len; ++i) {
                int next = map[cur].get(i);
                if(cost[next] == -1) {
                    cost[next] = cost[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        map = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) map[i] = new ArrayList<>();
        
        for(int i = 0; i < roads.length; i++) {
            map[roads[i][0]].add(roads[i][1]);
            map[roads[i][1]].add(roads[i][0]);
        }
        
        cost = new int[n + 1];
        Arrays.fill(cost, -1);
        bfs(destination);
        
        answer = new int[sources.length];
        
        for(int i = 0; i < sources.length; ++i) answer[i] = cost[sources[i]];
        
        return answer;
    }
}