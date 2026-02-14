class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int h = (int)Math.ceil((double) n / w);
        int[][] boxes = new int[h][w];
        
        int row = 0;
        int cur = 1;
        int ti = -1;
        int tj = -1;
        for(int i = 0; i < h; i++) {
            if((i % 2) == 0) {
                for(int j = 0; j < w && cur <= n; j++) {
                    boxes[i][j] = cur;
                    if(cur == num) {
                        ti = i;
                        tj = j;
                    }
                    cur++;
                }
            } else {
                for(int j = w - 1; j >= 0 && cur <= n; j--) {
                    boxes[i][j] = cur;
                    if(cur == num) {
                        ti = i;
                        tj = j;
                    }
                    cur++;
                }
            }
            
        }
        
        for (int i = h - 1; i >= ti; i--) {
            if (boxes[i][tj] != 0) answer++;
        }
        
        return answer;
    }
}