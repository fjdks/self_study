import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : A) pq.add(a);
        
        Arrays.sort(B);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int b : B) dq.add(b);
        
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            if(cur < dq.peekLast()) {
                answer++;
                dq.pollLast();
            } else dq.pollFirst();
        }
        
        return answer;
    }
}