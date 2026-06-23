class Solution {
    public String solution(int n) {
        String pat = "박수";
        String answer = "";
        int cur = 1;
        while(cur <= n) {
            answer += pat.charAt(cur++ % 2);
        }
        return answer;
    }
}