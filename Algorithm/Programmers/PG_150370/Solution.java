package PG_150370;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	static int getDate(String date) {
		String[] arr = date.split("\\.");
		
		int y = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int d = Integer.parseInt(arr[2]);
		
		return (y * 12 * 28) + (m * 28) + d;
	}
	
	static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int checkDate = getDate(today);
         
        for(String s : terms){
            String[] term = s.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            
            if(getDate(privacy[0]) + (map.get(privacy[1]) * 28) <= checkDate){
                answer.add(i + 1);
            }
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
	
	public static void main(String[] args) throws Exception {
		String today = "2022.05.19";
		String[] terms = new String[]{"A 6", "B 12", "C 3"};
		String[] privacies = new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		System.out.println(Arrays.toString(solution(today, terms, privacies)));
	}

}

/*
2022.05.19
A 6
B 12
C 3
2021.05.02 A
2021.07.01 B
2022.02.19 C
2022.02.20 C
*/