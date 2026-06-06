import java.util.*;

class Solution {
    static HashSet<Integer> set;
    
    static void perm(char[] arr, int D, int R, boolean[] v, char[] sel) {
        if(D == R) {
            int cur = Integer.parseInt(String.valueOf(sel));
            if(isPrime(cur)) set.add(cur);
            return;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(v[i]) continue;
            sel[D] = arr[i];
            v[i] = true;
            perm(arr, D + 1, R, v, sel);
            v[i] = false;
        }
    }
    
    static boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        char[] arr = new char[numbers.length()];
        for(int i = 0; i < numbers.length(); i++) arr[i] = numbers.charAt(i);
        
        set = new HashSet<>();
        int len = numbers.length();
        for(int r = 1; r <= len; r++) perm(arr, 0, r, new boolean[len], new char[r]);
        
        return set.size();
    }
}