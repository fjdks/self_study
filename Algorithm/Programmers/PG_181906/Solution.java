class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        String arr = my_string.substring(0, Math.min(is_prefix.length(), my_string.length()));
        System.out.println(arr);
        if(arr.equals(is_prefix)) answer = 1;
        return answer;
    }
}