import java.util.*;

class Solution {
    static int[] parent;
    
    static int find(int x) {
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    static int kruskal(int[][] graph) {
        int cost = 0;
        for(int i = 0; i < graph.length; i++) {
            if(find(graph[i][0]) != find(graph[i][1])) {
                cost += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        return cost;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        return kruskal(costs);
    }
}