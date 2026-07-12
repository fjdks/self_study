class Solution {
    static int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
    
    static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }
    public int[] solution(int n, int m) {
        return new int[]{GCD(n, m), LCM(n, m)};
    }
}