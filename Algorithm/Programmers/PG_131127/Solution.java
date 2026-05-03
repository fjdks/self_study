import java.util.*;

class Solution {
    static boolean check(HashMap<String, Integer> map) {
        for(int i : map.values()) if(i != 0) return false;
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int total = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            total += number[i];
        }
        for(int i = 0; i < total; i++) {
            if(map.containsKey(discount[i])) map.replace(discount[i], (map.get(discount[i]) - 1));
        }
        if(check(map)) answer++;
        
        for(int i = 0; i < discount.length - total; i++) {
            if(map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) + 1);
            }
            if(map.containsKey(discount[i + total])) {
                map.put(discount[i + total], map.get(discount[i + total]) - 1);
            }
            // System.out.println(i + " " + map.toString());
            if(check(map)) answer++;
            
        }
        
        
        return answer;
    }
}