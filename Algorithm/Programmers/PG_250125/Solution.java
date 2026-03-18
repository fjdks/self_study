class Solution {
    static int[] dh = new int[] {-1, 1, 0, 0};
    static int[] dw = new int[] {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int count = 0;
        String color = board[h][w];
        for(int d = 0; d < 4; d++) {
            int nh = h + dh[d];
            int nw = w + dw[d];
            if(0 <= nh && nh < board.length && 0 <= nw && nw < board.length && board[nh][nw].equals(color)) answer++;
        }
        
        
        return answer;
    }
}