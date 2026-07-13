class Solution {
    
    static boolean comp(String a, String b) {
        Long T = Long.parseLong(a);
        Long P = Long.parseLong(b);
        if(T <= P) return true;
        else return false;
    }

    public int solution(String t, String p) {
        int answer = 0;
        String str = "";
        for(int i = 0; i <= t.length() - p.length(); i++) {
            str = t.substring(i, i + p.length());
            if(comp(str, p)) answer++;
        }
        return answer;
    }
}