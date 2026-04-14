import java.util.*;

public class Music implements Comparable<Music> {
    String genre;
    int sum;
    int first;
    int second;
    int fidx;
    int sidx;

    public Music (String genre, int sum, int first, int fidx, int second, int sidx) {
        this.genre = genre;
        this.sum = sum;
        this.first = first;
        this.fidx = fidx;
        this.second = second;
        this.sidx = sidx;
    }
    
    public String toString(){
        return genre + ", " + first + ", " + second + ", " + fidx + ", " + sidx;
    }
    
    @Override
    public int compareTo(Music m) {
        return m.sum - this.sum;
    }
    
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashSet<String> set = new HashSet<>();
        for(String s : genres) set.add(s);
        // System.out.println(set.toString());
        
        Music[] music = new Music[set.size()];
        int idx = 0;
        for(String s : set) music[idx++] = new Music(s, 0, -1, -1, -1, -1);
        
        for(int i = 0; i < genres.length; i++) {
            String cur = genres[i];
            int p = plays[i];
            for(int j = 0; j < music.length; j++) {
                if(cur.equals(music[j].genre)) {
                    music[j].sum += p;
                    if(music[j].first < p) {
                        int tmp = music[j].first;
                        idx = music[j].fidx;
                        music[j].first = p;
                        music[j].fidx = i;
                        music[j].second = tmp;
                        music[j].sidx = idx;
                    } else if(music[j].second < p) {
                        music[j].second = p;
                        music[j].sidx = i;
                    }
                    break;
                }
            }
            
        }
        
        
        Arrays.sort(music);
        // for(int q = 0; q < set.size(); q++) System.out.println(music[q].toString());
        
        ArrayList<Integer> arr = new ArrayList<>();
        idx = 0;
        while(idx < music.length){
            arr.add(music[idx].fidx);
            if(music[idx].second != -1) arr.add(music[idx].sidx);
            idx++;
        }
        // System.out.println(arr.toString());
        answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) answer[i] = arr.get(i);
        
        
        return answer;
    }
}