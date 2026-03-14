// import java.util.*;
// import java.io.*;

class Solution {
    public static void swap (int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void sort(int[] m) {
        for(int i = 0; i < m.length - 1; i++) {
            int max_pos = i;
            for(int j = i + 1; j < m.length; j++) {
                if(m[max_pos] < m[j]){
                    max_pos = j;
                }
            }
            swap(m, i, max_pos);
        }
    }
    
    public static boolean check(int pos_i, int pos_j, int size, String[][] park) {
        boolean flag = true;
        loop: for(int j = pos_j; j < pos_j + size; j++) {
            for(int i = pos_i; i < pos_i + size; i++) {
                if(!park[j][i].equals("-1")) {
                    flag = false;
                    break loop;
                }
            }
        }
        
        return flag;
    }
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        sort(mats);
        loop: for(int m = 0; m < mats.length; m++) {
            for(int j = 0; j < park.length - mats[m] + 1; j++) {
                for(int i = 0; i < park[0].length - mats[m] + 1; i++) {
                    if(park[j][i].equals("-1")) {
                        if(check(i, j, mats[m], park)) {
                            answer = mats[m];
                            break loop;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}