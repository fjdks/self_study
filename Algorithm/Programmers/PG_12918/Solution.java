class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;
        for(int i = 0; i < s.length(); i++) {
            if('0' > s.charAt(i) || '9' < s.charAt(i)) return false;
        }
        return true;
    }
}