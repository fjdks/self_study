import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) map.replace(tangerine[i], map.get(tangerine[i]) + 1);
            else map.put(tangerine[i], 1);
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        int idx = 0;
        while(k > 0) {
            k -= values.get(idx);
            answer++;
            idx++;
        }
        
        
        return answer;
    }
}