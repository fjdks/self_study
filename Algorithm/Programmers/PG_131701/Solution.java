import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> sums = new HashSet<>();
        int[] new_arr = new int[elements.length * 2];
        for(int i = 0; i < new_arr.length; i++) new_arr[i] = elements[i % elements.length];
        // System.out.println(Arrays.toString(new_arr));
        for(int len = 1; len <= elements.length; len++) {
            for(int start = 0; start < elements.length; start++) {
                int sum = 0;
                for(int sub = start; sub < start + len; sub++) {
                    sum += new_arr[sub];
                }
                sums.add(sum);
            }
        }
        // System.out.println(sums.toString());
        
        
        return sums.size();
    }
}