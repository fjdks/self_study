import java.util.*;

class Solution {
    static int max;
    static int[][] ret;
    static void perm(int D, int k, int[][] arr, boolean[] v) {
        if(D == arr.length){
            int cnt = 0;
            for(int[] r : ret) {
                if(r[0] <= k) {
                    k -= r[1];
                    cnt++;
                } else continue;
            }
            max = Math.max(max, cnt);
        }
        for(int i = 0; i < arr.length; i++) {
            if(v[i]) continue;
            
            v[i] = true;
            ret[D] = arr[i];
            perm(D + 1, k, arr, v);
            v[i] = false;
        }
    }
    public int solution(int k, int[][] dungeons) {
        int answer = 0;

        ret = new int[dungeons.length][2];
        max = 0;
        perm(0, k, dungeons, new boolean[dungeons.length]);
        
        answer = max;
        
        return answer;
    }
}