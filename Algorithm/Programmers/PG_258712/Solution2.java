import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int f_len = friends.length;
        int[] giftCnt = new int[f_len];
        int[][] giftGraph = new int[f_len][f_len];
        
        HashMap<String, Integer> dic = new HashMap<>();
        for(int i = 0; i < f_len; i++) dic.put(friends[i], i);
        
        for(String gift : gifts) {
            String[] g = gift.split(" ");
            giftCnt[dic.get(g[0])]++;
            giftCnt[dic.get(g[1])]--;
            giftGraph[dic.get(g[0])][dic.get(g[1])]++;
        }
        
        for(int i = 0; i < f_len; i++) {
            int num = 0;
            for(int j = 0; j < f_len; j++) {
                if(i == j) continue;
                if(giftGraph[i][j] > giftGraph[j][i] || (giftGraph[i][j] == giftGraph[j][i] && giftCnt[i] > giftCnt[j])) num++;
                answer = Math.max(answer, num);
            }
            
            
        }
        
        
        
        return answer;
    }
}