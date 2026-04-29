import java.util.*;

class Solution {
    static HashSet<String> set;
    static ArrayList<String> route;
    static boolean[] v;
    static void dfs(int depth, String now, String path, String[][] tickets) {
        if(depth == tickets.length) {
            route.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!v[i] && now.equals(tickets[i][0])) {
                v[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                v[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        set = new HashSet<>();
        for(int i = 0; i < tickets.length; i++) {
            set.add(tickets[i][0]);
            set.add(tickets[i][1]);
        }
        
        route = new ArrayList<>();
        v = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(route);
        
        return route.get(0).split(" ");
    }
}