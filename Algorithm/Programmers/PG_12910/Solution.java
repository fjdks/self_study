import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) if((arr[i] % divisor) == 0) pq.add(arr[i]);
        
        if(pq.size() == 0) return new int[] {-1};
        answer = new int[pq.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = pq.poll();
        
        return answer;
    }
}