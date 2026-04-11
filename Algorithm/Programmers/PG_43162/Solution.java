class Solution {    
    static void dfs(int node, boolean[] v, int[][] coms){
        v[node] = true;
        for(int i = 0; i < coms[0].length; i++) {
            if(!v[i] && coms[node][i] == 1) {
                dfs(i, v, coms);
            }
        }
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, visited, computers);
            }
        }
        
        return answer;
    }
}