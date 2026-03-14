class Solution {
    public int solution(String my_string, String target) {
        int answer = 0;
        for(int i = 0; i < my_string.length() - target.length() + 1; i++) {
            if(my_string.charAt(i) == target.charAt(0)) {
                boolean flag = true;
                for(int j = 0; j < target.length(); j++) {
                    if(my_string.charAt(i + j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    answer = 1;
                    break;
                }
            }
        }
        return answer;
    }
}