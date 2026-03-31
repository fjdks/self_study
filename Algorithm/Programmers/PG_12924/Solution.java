class Solution {
    public int solution(int n) {
        int answer = 0;
        int start, sum;
        for(int i = 1; i <= n; i++) {
            start = i;
            sum = 0;
            while(start <= n) {
                sum += start++;
                if(sum == n) answer++;
                else if(sum > n) break;
            }
        }
        
        return answer;
    }
}