import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = Long.toString(n);
        
        Character[] arr = new Character[str.length()];
        for(int i = 0; i < str.length(); i++) arr[i] = str.charAt(i);
        Arrays.sort(arr, Collections.reverseOrder());
        str = "";
        for(char c: arr) str += c;
        answer = Long.parseLong(str);
        
        return answer;
    }
}