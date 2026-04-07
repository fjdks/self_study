import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
                
        int tel, jump;
        while(n >= 2) {
            jump = n % 2;
            ans += jump;
            n /= 2;
        }
        return ans;
    }
}