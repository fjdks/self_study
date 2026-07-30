import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();
        for(String card : cards1) q1.add(card);
        for(String card : cards2) q2.add(card);
        
        for(int i = 0; i < goal.length; i++){
            if(goal[i].equals(q1.peek())) q1.poll();
            else if(goal[i].equals(q2.peek())) q2.poll();
            else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}