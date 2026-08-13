import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if(map[c - 'A'] == -1) map[c - 'A'] = j + 1;
                else map[c - 'A'] = Math.min(map[c - 'A'], j + 1);
            }
        }
        for(int i = 0; i < targets.length; i++) {
            int click = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                if(map[targets[i].charAt(j) - 'A'] == -1) {
                    answer[i] = -1;
                    break;
                } else click += map[targets[i].charAt(j) - 'A'];
            }
            if(answer[i] != -1) answer[i] = click;
        }
        
        
        return answer;
    }
}