import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        boolean flag = false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0) sb.append(Character.toString(s.charAt(i)).toUpperCase());
            else if(flag) {
                sb.append(Character.toString(s.charAt(i)).toUpperCase());
                flag = false;
            }
            else if(!flag) sb.append(Character.toString(s.charAt(i)).toLowerCase());
            if(s.charAt(i) == ' ') flag = true;
            
            
        }
        return sb.toString();
    }
}