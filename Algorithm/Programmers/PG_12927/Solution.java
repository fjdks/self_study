import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) pq.add(w);
        while(n > 0) {
            int cur = pq.poll();
            cur--;
            n--;
            pq.add(cur);
        }
        for(int work : pq) answer += (work <= 0 ? 0 : Math.pow(work, 2));
        return answer;
    }
}