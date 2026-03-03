class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int day = startday - 1;
        int mems = schedules.length;
        int limit = 0;
        boolean flag = true;
        
        for(int i = 0; i < mems; i++){
            day = startday - 1;
            flag = true;
            limit = schedules[i] + 10;
            if((limit % 100) >= 60) {
                limit -= 60;
                limit += 100;
            }
            
            for(int j = 0; j < 7; j++) {
                if(day < 5) {
                    if(timelogs[i][j] > limit) flag = false;
                }
                day = (day + 1) % 7;
            }
            if(flag) answer++;
            
        }
        
        
        return answer;
    }
}