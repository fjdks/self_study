import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) min = Math.min(min, arr[i]);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) continue;
            answer.add(arr[i]);
        }
        if(answer.size() == 0) answer.add(-1);
        
        return answer;
    }
}