class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int idx = Math.max((my_string.length() - is_suffix.length()), 0);
        String arr = my_string.substring(idx);
        if(arr.equals(is_suffix)) answer = 1;
        return answer;
    }
}