import java.util.*;

class Solution {
    public int solution(int n) {
        String bin_n = Integer.toBinaryString(n);
        int n_cnt = 0;
        for(int i = 0; i < bin_n.length(); i++) if(bin_n.charAt(i) == '1') n_cnt++;
        
        while(true) {
            n++;
            String new_bin_n = Integer.toBinaryString(n);
            int new_n_cnt = 0;
            for(int i = 0; i < new_bin_n.length(); i++) {
                if(new_bin_n.charAt(i) == '1') new_n_cnt++;
            }
            if(n_cnt == new_n_cnt) break;
        }
        
        
        return n;
    }
}