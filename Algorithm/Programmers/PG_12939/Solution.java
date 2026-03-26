import java.util.*;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] arr = s.split(" ");
        
        for(int i = 0; i < arr.length; i++){
            int cur = Integer.parseInt(arr[i]);
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }
        
        
        return min + " " + max;
    }
}