import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr = s.split("-");
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
                
        List<Integer> list = new ArrayList<>();
        for(String el : arr) {
            String[] line = el.split(",");
            for(int i = 0; i < line.length; i++) {
                int num = Integer.parseInt(line[i]);
                if(!list.contains(num)) list.add(num);
            }
        }
        
        return list;
    }
}