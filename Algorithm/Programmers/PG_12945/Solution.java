class Solution {
    static int[] fibo;
    
    static int fibonacci(int x) {
        int[] fibo = new int[x + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2; i <= x; i++) fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
        return fibo[x];
    }
    
    public int solution(int n) {
        int answer = 0;
        return fibonacci(n);
    }
}