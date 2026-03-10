import java.util.*;
import java.io.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        int len = message.length();
        boolean[] check = new boolean[len];
        for(int i = 0; i < spoiler_ranges.length; i++) {
            for(int j = spoiler_ranges[i][0]; j <= spoiler_ranges[i][1]; j++) {
                check[j] = true;
            }
        }
        
        Set<String> set = new HashSet<>();
        Set<String> words = new HashSet<>();
        int idx = 0;
        String s = "";
        boolean flag = false;
        message += " ";
        while(idx <= len) {
            char c = message.charAt(idx);
            if(c != ' ') {
                s += c;
                if(check[idx]) flag = true;
            } else {
                if(flag) {
                    if(!words.contains(s)) set.add(s);
                } else {
                    words.add(s);
                    set.remove(s);
                }
                s = "";
                flag = false;
            }
            idx++;
        }
        return set.size();
    }
}