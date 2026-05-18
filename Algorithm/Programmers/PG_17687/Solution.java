import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int cur = 0; // 현재 숫자
        int turn = 0; // 현재 순서
        
        Queue<Character> s = new ArrayDeque<>();
        while(answer.length() < t) {
            if(s.isEmpty()) {
                String tmp = Integer.toString(cur++, n).toUpperCase();
                for(int i = 0; i < tmp.length(); i++) s.offer(tmp.charAt(i));
            }
            char str = s.poll();
            if(turn + 1 == p) answer += str;
            turn = ((turn + 1) % m);
        }
        return answer;
    }
}