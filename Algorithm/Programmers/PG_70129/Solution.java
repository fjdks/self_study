import java.util.*;

class Solution {
    public int[] solution(String s) {
        int del = 0;
        int cnt = 0;
        StringBuilder sb;
        while(!s.equals("1")) {
            cnt++;
            int len = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') len++;
                else del++;
            }

            sb = new StringBuilder();
            int tmp = len;
            while(tmp != 0) {
                sb.append(Integer.toString(tmp % 2));
                tmp /= 2;
            }
            s = sb.reverse().toString();
        }
        
        return new int[]{cnt, del};
    }
}