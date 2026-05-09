import java.util.*;

class Solution {
    static int time;
    static ArrayList<String> cache;

    
    static void LRU(String input, int cacheSize) {
        if(cache.contains(input)) {
            cache.remove(input);
            cache.add(input);
            time++;
        } else {
            if(cache.size() == cacheSize) cache.remove(0);
            cache.add(input);
            time += 5;
        }
    }
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        cache = new ArrayList<>();
        time = 0;
        if(cacheSize == 0) return cities.length * 5;
        for(String city : cities) LRU(city.toUpperCase(), cacheSize);
        answer = time;
        
        return answer;
    }
}