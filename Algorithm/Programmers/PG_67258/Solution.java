import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++) set.add(gems[i]);
        int kind = set.size();
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);
        int left = 0;
        int right = 0;
        while(left <= right) {
            int cnt = map.size();
            if(cnt == kind && right - left < answer[1] - answer[0]) {
                answer[1] = right + 1;
                answer[0] = left + 1;
            }
            
            if(cnt < kind) {
                if(++right == gems.length) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            } else {
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0) map.remove(gems[left]);
                left++;
            }
        }
        
        
        return answer;
    }
}