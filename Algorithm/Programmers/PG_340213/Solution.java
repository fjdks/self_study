class Solution {
    static int m, s;

    static void Opening(String op_start, String op_end) {
        int start_m = Integer.parseInt(op_start.substring(0,2));
        int start_s = Integer.parseInt(op_start.substring(3));
        int end_m = Integer.parseInt(op_end.substring(0,2));
        int end_s = Integer.parseInt(op_end.substring(3));
    
        if(start_m < m && m < end_m) {
            m = end_m;
            s = end_s;
        } else if(start_m == m && m <= end_m) {
            if(start_s <= s && s <= end_s) {
                m = end_m;
                s = end_s;
            }
        } else if(end_m == m && m >= start_m) {
            if(start_s <= s && s <= end_s) {
                m = end_m;
                s = end_s;
            }
        }
    }
    
    static void check(String video_len) {
        int end_m = Integer.parseInt(video_len.substring(0,2));
        int end_s = Integer.parseInt(video_len.substring(3));
        
        if(m < 0) {
            m = 0;
            s = 0;
        } else {
            if(m >= end_m && s > end_s) {
                m = end_m;
                s = end_s;
            }
        }
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        for(int command = 0; command < commands.length; command++) {
            m = Integer.parseInt(pos.substring(0,2));
            s = Integer.parseInt(pos.substring(3));
            Opening(op_start, op_end);
            if(commands[command].equals("next")) {
                s += 10;
                if(s >= 60) {
                    m += 1;
                    s -= 60;
                }
            } else {
                s -= 10;
                if(s < 0) {
                    m -= 1;
                    s += 60;
                }
            }
            
            check(video_len);
            Opening(op_start, op_end);
            
            pos = ((m < 10) ? "0" : "") + Integer.toString(m) + ":" + ((s < 10) ? "0" : "") + Integer.toString(s);
            
        }
        return pos;
    }
}