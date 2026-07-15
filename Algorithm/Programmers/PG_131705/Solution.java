class Solution {
    static int answer;
    static void comb(int R, int N, int start, int idx, int[] nums, int[] sel) {
        if(idx == R) {
            int sum = 0;
            for(int i : sel) sum += i;
            if(sum == 0) answer++;
            return;
        }
        for(int i = start; i < N; i++) {
            sel[idx] = nums[i];
            comb(R, N, i + 1, idx + 1, nums, sel);
        }
    }
    
    public int solution(int[] number) {
        answer = 0;
        comb(3, number.length, 0, 0, number, new int[3]);
        return answer;
    }
}