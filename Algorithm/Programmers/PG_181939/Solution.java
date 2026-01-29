class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String A = Integer.toString(a);
        String B = Integer.toString(b);
        return Math.max(Integer.parseInt(A + B), Integer.parseInt(B + A));
    }
}