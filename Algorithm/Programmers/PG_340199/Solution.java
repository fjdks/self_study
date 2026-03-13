class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int w_max = (wallet[0] > wallet[1]) ? wallet[0] : wallet[1];
        int w_min = (wallet[0] < wallet[1]) ? wallet[0] : wallet[1];
        int b_max = 10;
        int b_min = 2000;
        while(true) {
            b_max = (bill[0] > bill[1]) ? bill[0] : bill[1];
            b_min = (bill[0] < bill[1]) ? bill[0] : bill[1];
            if((b_min <= w_min) && (b_max <= w_max)) break;
            b_max = (int)Math.floor(b_max/2);
            bill = new int[]{b_max, b_min};
            answer++;
        }
        return answer;
    }
}