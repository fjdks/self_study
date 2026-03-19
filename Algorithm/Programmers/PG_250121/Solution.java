import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        String[] exts = new String[]{"code", "date", "maximum", "remain"};
        for(int i = 0; i < 4; i++) map.put(exts[i], i);
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            if(data[i][map.get(ext)] < val_ext) list.add(data[i]);
        }
        
        answer = new int[list.size()][4];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[map.get(sort_by)] - o2[map.get(sort_by)];
            }
        });
        return answer;
    }
}