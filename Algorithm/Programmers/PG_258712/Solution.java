class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] list = new int[friends.length + 1][friends.length + 1];
        
        for(int i = 0; i < gifts.length; i++) {
            String[] arr = gifts[i].split(" ");
            int send = -1;
            int receive = -1;
            int cnt = 0;
            for(int j = 0; j < friends.length; j++) {
                if(cnt == 2) break;
                if(friends[j].equals(arr[0])) {
                    cnt++;
                    send = j;
                }
                else if(friends[j].equals(arr[1])) {
                    cnt++;
                    receive = j;
                }
            }
            list[send][receive]++;
            list[send][friends.length]++;
            list[friends.length][receive]++;
        }
        int[] cnt = new int[friends.length];
        int[] score = new int[friends.length];
        for(int i = 0; i < friends.length; i++) {
            score[i] = list[i][friends.length] - list[friends.length][i];
        }
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                if(list[i][j] - list[j][i] == 0) {
                    if(score[i] > score[j]) cnt[i]++;
                    else if(score[i] < score[j]) cnt[j]++;
                } else {
                    if(list[i][j] > list[j][i]) cnt[i]++;
                    else cnt[j]++;
                }
            }
            
        }
        for(int i = 0; i < cnt.length; i++) answer = Math.max(answer, cnt[i]);
        
        return answer / 2;
    }
}