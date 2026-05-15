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
        String converted = (k == 10 ? Integer.toString(n) : Integer.toString(n, k));
        String[] arr = converted.split("0");
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")) continue;
            String str = arr[i].replace(" ", "");
            if(isPrime(Long.parseLong(str))) answer++;
        }
        
        return answer;
    }
}