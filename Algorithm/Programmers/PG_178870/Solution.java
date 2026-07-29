class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int len = Integer.MAX_VALUE;
        while(start <= end && end < sequence.length) {
            if (sum < k) {
                end++;
                if (end < sequence.length) {
                    sum += sequence[end];
                }
            } else {
                if (sum == k) {
                    if (len > end - start + 1) {
                        len = end - start + 1;
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                
                sum -= sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}