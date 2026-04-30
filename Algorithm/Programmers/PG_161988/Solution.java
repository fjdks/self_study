import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] arr1 = new int[sequence.length];
        int[] arr2 = new int[sequence.length];
        int sign = 1;
        for(int i = 0; i < sequence.length; i++) {
            arr1[i] = sequence[i] * sign;
            arr2[i] = sequence[i] * sign * -1;
            sign *= -1;
        }
        
        long[] dp = new long[sequence.length];
        dp[0] = arr1[0];
        long max1 = arr1[0];
        for(int i = 1; i < arr1.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr1[i], arr1[i]);
            max1 = Math.max(max1, dp[i]);
        }
        
        dp = new long[sequence.length];
        dp[0] = arr2[0];
        long max2 = arr2[0];
        for(int i = 1; i < arr2.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr2[i], arr2[i]);
            max2 = Math.max(max2, dp[i]);
        }
        
        
        return Math.max(max1, max2);
    }
}