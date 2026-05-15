import java.util.*;

class Solution {
    static boolean isPrime(long num) {
        if(num == 1) return false;
        for(long i = 2; i <= Math.sqrt(num); i++) {
            if((num % i) == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String converted = Integer.toString(n, k);
        String[] arr = converted.split("0");
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")) continue;
            if(isPrime(Long.parseLong(arr[i]))) answer++;
        }
        
        return answer;
    }
}