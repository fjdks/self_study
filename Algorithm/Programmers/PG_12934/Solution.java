import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long)Math.sqrt(n);
        answer = (sqrt * sqrt == n) ? (sqrt + 1) * (sqrt + 1) : -1;
        
        return answer;
    }
}