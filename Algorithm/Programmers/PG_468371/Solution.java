class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        int qua = signals.length;
        
        int time = 1;
        int cnt = 0;
        int max = 1;
        for(int i = 0; i < qua; i++) {
            max *= (signals[i][0] + signals[i][1] + signals[i][2]);
        }
        while(time <= max) {
            cnt = 0;
            for(int i = 0; i < qua; i++) {
                int cycle = signals[i][0] + signals[i][1] + signals[i][2];
                int mod = time % cycle;
                if(signals[i][0] < mod && mod <= (signals[i][0] + signals[i][1])) cnt++;
            }
            if(cnt == qua) break;
            time++;
        }
        answer = (time > max) ? -1 : time;
        return answer;
    }
}