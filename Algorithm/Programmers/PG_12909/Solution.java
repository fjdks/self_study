import java.util.*; 

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        if(s.length() % 2 == 1) return false;
        if(s.charAt(0) == ')') return false;
        
        stack.push('(');
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push('(');
            else {
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }
        }
        if(!stack.isEmpty()) return false;
        
        return answer;
    }
}