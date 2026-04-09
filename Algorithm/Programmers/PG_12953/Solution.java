class Solution {
    static int LCM(int[] arr){
        int res = arr[0];
        for(int i = 0 ; i < arr.length; i++) {
            res = LCM(res, arr[i]);
        }
        return res;
    }
    
    static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }
    
    static int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
    
    public int solution(int[] arr) {
        int answer = LCM(arr);
        return answer;
    }
}