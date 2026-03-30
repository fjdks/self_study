import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        
        Integer[] nA = new Integer[A.length];
        for(int i = 0; i < A.length; i++) nA[i] = A[i];
        Integer[] nB = new Integer[B.length];
        for(int i = 0; i < B.length; i++) nB[i] = B[i];
        
        Arrays.sort(nA);
        Arrays.sort(nB, Collections.reverseOrder());
        for(int i = 0; i < nA.length; i++) answer += nA[i] * nB[i];
 
        return answer;
    } 
}