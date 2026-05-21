import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        
        int idx = 1;
        for(char c = 'A'; c <= 'Z'; c++) dict.put(String.valueOf(c), idx++);
        
        // System.out.println(dict.toString());
        
        idx = 27;
        for(int i = 0; i < msg.length(); i++) {
            String word = "";
            
            while(i < msg.length() && dict.containsKey(word + msg.charAt(i))) {
                word += msg.charAt(i);
                i++;
            }
            answer.add(dict.get(word));
            
            if(i < msg.length()) {
                dict.put(word + msg.charAt(i), idx++);
                i--;
            }
            
        }
        
        
        return answer;
    }
}