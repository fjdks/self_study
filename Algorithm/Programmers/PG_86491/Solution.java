class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int v_max = 0;
        int h_max = 0;
        for(int i = 0; i < sizes.length; i++) {
            v_max = Math.max(Math.max(sizes[i][0], sizes[i][1]), v_max);
            h_max = Math.max(Math.min(sizes[i][0], sizes[i][1]), h_max);
        }
        return v_max * h_max;
    }
}