import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        int div = 10;
        String num = Integer.toString(x);
        for(int i = 0; i < num.length(); i++) sum += num.charAt(i) - '0';
        
        return x % sum == 0 ? true : false;
    }
}