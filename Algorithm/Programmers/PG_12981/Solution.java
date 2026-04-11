import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};
        Set<String> set = new HashSet<>();
        
        String last = "";
        for(int i = 0; i < words.length; i++) {
            if(set.isEmpty()) {
                set.add(words[i]);
                last = words[i];
            } else if(set.contains(words[i])) {
                answer = new int[]{(i % n) + 1, (i / n) + 1};
                break;
            } else if(last.charAt(last.length() - 1) != (words[i].charAt(0))) {
                answer = new int[]{(i % n) + 1, (i / n) + 1};
                break;
            } else {
                set.add(words[i]);
                last = words[i];
            }
        }

        return answer;
    }
}