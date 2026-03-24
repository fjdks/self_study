import java.util.*;

class Solution {
    static int[] di = new int[]{-1, 1, 0, 0};
    static int[] dj = new int[]{0, 0, -1, 1};
    static char[][] board;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        board = new char[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                char c = park[i].charAt(j);
                board[i][j] = c;
                if(c == 'S') answer = new int[]{i, j};
            }
        }
        
        char[] direction = new char[]{'N', 'S', 'W', 'E'};
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 4; i++) map.put(direction[i], i);
        
        
        for(int i = 0; i < routes.length; i++) {
            char dir = routes[i].charAt(0);
            int dis = routes[i].charAt(2) - '0';
            
            int ni = answer[0];
            int nj = answer[1];
            boolean flag = true;
            for(int d = 0; d < dis; d++){
                ni += di[map.get(dir)];
                nj += dj[map.get(dir)];
                if(ni < 0 || board.length <= ni || nj < 0 || board[0].length <= nj || board[ni][nj] == 'X') {
                    flag = false;
                    break;
                }
            }
            if(flag) answer = new int[]{ni, nj};
            
        }
        
        return answer;
    }
}