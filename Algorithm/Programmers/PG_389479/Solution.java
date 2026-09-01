import java.util.*;

class Solution {
    static int[] servers;
    
    static void addServer(int start_time, int k, int div) {
        for(int i = start_time; i < Math.min(24, start_time + k); i++) servers[i] += div;
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        servers = new int[24];
        
        for(int time = 0; time < 24; time++) {
            int div = players[time] / m;
            if(div > 0 && div > servers[time]) {
                answer += Math.max(0, div - servers[time]);
                addServer(time, k, Math.max(0, div - servers[time]));
            }
        }
        
        return answer;
    }
}