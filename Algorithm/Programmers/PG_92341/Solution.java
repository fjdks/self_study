import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> lot = new HashMap<>();
        HashMap<String, Integer> sum = new HashMap<>();
        String[] record = {};
        for(int i = 0; i < records.length; i++) {
            record = records[i].split(" ");
            String[] time = record[0].split(":");
            int conv = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
            if(record[2].equals("IN")) lot.put(record[1], conv);
            else {
                sum.put(record[1], (sum.getOrDefault(record[1], 0)) + (conv - lot.get(record[1])));
                lot.remove(record[1]);
            }
            
        }
        if(!lot.isEmpty()) {
            for(String car : lot.keySet()) sum.put(car, sum.getOrDefault(car, 0) + (1439 - lot.get(car)));
        }
        
        List<String> keyList = new ArrayList<>(sum.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        for(String key : keyList) {
            int fee = fees[1];
            int time = sum.get(key);
            if(time > fees[0]) {
                fee += (((time - fees[0]) / fees[2]) * fees[3]);
                if((time - fees[0]) % fees[2] != 0) fee += fees[3];
            }
            answer.add(fee);
        }
        
        return answer;
    }
}