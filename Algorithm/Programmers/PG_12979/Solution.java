class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = (w * 2) + 1;
        
        int start = 1;
        int size = 0;
        for(int i = 0; i < stations.length; i++) {
            size = (stations[i] - w) - start;
            if(0 < size && size < range) answer++;
            else if(range <= size) answer += ((size / range) + ((size % range) == 0 ? 0 : 1));
            start = stations[i] + w + 1;    
        }
        size = n - start + 1;
        if(0 < size && size < range) answer++;
        else if(range <= size) answer += ((size / range) + ((size % range) == 0 ? 0 : 1));
        
        return answer;
    }
}