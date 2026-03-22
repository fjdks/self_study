import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) map.put(players[i], i);
        
        for(int i = 0; i < callings.length; i++) {
            int cur_rank = map.get(callings[i]);
            String name = players[cur_rank - 1];
            map.replace(name, cur_rank);
            players[cur_rank] = name;
            
            map.replace(callings[i], cur_rank - 1);
            players[cur_rank - 1] = callings[i];
        }
        
        return players;
    }
}