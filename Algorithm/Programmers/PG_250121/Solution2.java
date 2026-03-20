import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        String[] exts = new String[]{"code", "date", "maximum", "remain"};
        for(int i = 0; i < 4; i++) map.put(exts[i], i);
        
        answer = Arrays.stream(data).filter(o1 -> o1[map.get(ext)] < val_ext).sorted((o1, o2) -> o1[map.get(sort_by)] - o2[map.get(sort_by)]).toArray(int[][]::new);
        
        return answer;
    }
}