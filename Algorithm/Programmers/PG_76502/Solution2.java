import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = Map.of(')', '(', '}', '{' , ']', '[');
        Set<Character> set = Set.of('(' , '{', '[');
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        s += s;
        
        for(int i = 0; i < len; i++) {
            boolean flag = true;
            stack.clear();
            for(int idx = i; idx < i + len; idx++){
                char c = s.charAt(idx);
                if(set.contains(c)) stack.push(c);
                else {
                    if(stack.isEmpty() || stack.peek() != map.get(c)) flag = false;
                    else stack.pop();
                }
            }
            if(stack.isEmpty() && flag) answer++;
            
        }
        
        return answer;
    }
}