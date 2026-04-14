import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        
        int[] answer = {};
        int quo = s / n;
        int rem = s % n;
        
        answer = new int[n];
        Arrays.fill(answer, quo);
        if(rem == 0) return answer;
        
        for(int i = n - 1; i >= (n - rem); i--) answer[i]++;
        return answer;
    }
}