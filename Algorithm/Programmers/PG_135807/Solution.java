import java.util.*;

class Solution {

    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    static int gcd(int[] arr) {
        int result = arr[0];

        for(int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }

        return result;
    }

    static boolean check(int gcd, int[] arr) {
        for(int num : arr) {
            if(num % gcd == 0) return false;
        }

        return true;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);

        int answer = 0;

        if(check(gcdA, arrayB)) {
            answer = gcdA;
        }

        if(check(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }
}