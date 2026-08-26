import java.util.*;

class Solution {
    static int convert(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
    
        return hour * 60 + minute;
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, Comparator.comparing(a -> a[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String[] schedule : book_time) {

            int start = convert(schedule[0]);
            int end = convert(schedule[1]);
            if(!pq.isEmpty() && pq.peek() + 10 <= start) pq.poll();

            pq.add(end);
        }

        return pq.size();
    }
}