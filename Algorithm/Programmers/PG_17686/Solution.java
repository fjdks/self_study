import java.util.*;

class File implements Comparable<File> {
    String origin;
    String head;
    String number;
    
    public File(String origin, String head, String number) {
        this.origin = origin;
        this.head = head;
        this.number = number;
    }
    
    @Override
    public int compareTo(File o) {
        int headCompare = this.head.compareToIgnoreCase(o.head);
        if(headCompare != 0) return headCompare;
        
        int num1 = Integer.parseInt(this.number);
        int num2 = Integer.parseInt(o.number);
        if(num1 != num2) return num1 - num2;
        
        return 0;
    }
}

class Solution {
    static String[] divide(String str) {
        String head = "";
        String number = "";
        boolean flag = false;
        for(int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            if(Character.isDigit(c)) {
                flag = true;
                if(number.length() < 5) number += c;
            } else {
                if(!flag) head += c;
                else break;
            }
        }
        return new String[]{head, number};
    }
    
    public String[] solution(String[] files) {
        String[] answer = {};
        List<File> list = new ArrayList<File>();
        
        for(int i = 0; i < files.length; i++) {
            String[] sep = new String[2];
            sep = divide(files[i]);
            list.add(new File(files[i], sep[0], sep[1]));
        }
        
        answer = new String[files.length];        
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i).origin;
        
        return answer;
    }
}