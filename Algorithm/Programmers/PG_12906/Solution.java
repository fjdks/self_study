import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int cur = -1;
        for(int i : arr) {
            if(cur != i) {
                cur = i;
                answer.add(cur);
            }
        }

        return answer;
    }
}