class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int A = Integer.parseInt((a + "") + (b + ""));
        int B = 2 * a * b;
        answer = Math.max(A, B);
        return answer;
    }
}