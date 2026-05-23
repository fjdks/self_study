import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        
        int box = 1;
        for(int o : order) {
            while(box < o) sub.push(box++);
            
            if(box == o) {
                answer++;
                box++;
            } else if(!sub.isEmpty() && sub.peek() == o) {
                sub.pop();
                answer++;
            } else break;
        }
        
        return answer;
    }
}