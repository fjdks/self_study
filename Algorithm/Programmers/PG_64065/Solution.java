import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        String tmp = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '}') continue;
            else if(s.charAt(i) == ',') {
                if(tmp == "") continue;
                map.put(Integer.parseInt(tmp), (map.getOrDefault(Integer.parseInt(tmp), 0) + 1));
                tmp = "";
            } else tmp += s.charAt(i);
        }
        map.put(Integer.parseInt(tmp), (map.getOrDefault(Integer.parseInt(tmp), 0) + 1));
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for(int key: map.keySet()) {
            int[] cur = new int[]{key, map.get(key)};
            pq.add(cur);
        }
        
        answer = new int[pq.size()];
        int size = pq.size();
        for(int i = 0; i < size; i++) {
            int[] cur = pq.poll();
            answer[i] = cur[0];
        }
        
        return answer;
    }
}