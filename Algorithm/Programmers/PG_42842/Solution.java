import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        for(int i = 3; i <= Math.sqrt(total); i++) {
            if((total % i) == 0) {
                if((i - 2) * ((total / i) - 2) == yellow) {
                    answer = new int[]{(int)(total / i), i};
                    break;
                }
            }
        }
        return answer;
    }
}