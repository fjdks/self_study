import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        s += s;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            stack.clear();
            boolean flag = true;
            for(int idx = i; idx < i + len; idx++) {
                char c = s.charAt(idx);
                if(c == '(' || c == '{' || c == '[') stack.add(c);
                else {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    char p = stack.peek();
                    switch (c) {
                        case ')' :
                            if(p == '(') stack.pop();
                            else flag = false;
                            break;
                        case '}':
                            if(p == '{') stack.pop();
                            else flag = false;
                            break;
                        case ']':
                            if(p == '[') stack.pop();
                            else flag = false;
                            break;
                    }
                }
                if(!flag) break;
            }
            if(flag && stack.isEmpty()) answer++;
            
        }
        
        return answer;
    }
}