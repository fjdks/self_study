class Solution {
    public String solution(int[] food) {
        String answer = "";
        String arr = "";
        for(int i = 1; i < food.length; i++) {
            int div = food[i] / 2;
            if(div == 0) continue;
            for(int j = 0; j < div; j++) arr += i;
        }
        answer = arr;
        answer += "0";
        for(int i = arr.length() - 1; i >= 0; i--) answer += arr.charAt(i);
        return answer;
    }
}