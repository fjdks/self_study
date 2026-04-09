class Solution {
    public long solution(int n) {
        int[] fibo = new int[n + 2];
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 2;
        if(n > 2) {
            for(int i = 3; i <= n; i++) fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }
        return fibo[n];
    }
}