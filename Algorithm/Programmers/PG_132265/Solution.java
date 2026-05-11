import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        
        map1.put(topping[0], 1);
        for(int i = 1; i < topping.length; i++) map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        if(map1.size() == map2.size()) answer++;
        
        for(int i = 1; i < topping.length; i++) {
            map1.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
            if(map2.get(topping[i]) == 1) map2.remove(topping[i]);
            else map2.put(topping[i], map2.get(topping[i]) - 1);
            if(map1.size() == map2.size()) answer++;
        }
        
        return answer;
    }
}