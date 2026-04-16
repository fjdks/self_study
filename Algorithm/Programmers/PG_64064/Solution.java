import java.util.*;

class Solution {
    
    static HashSet<HashSet<String>> set;
    
    static void dfs(HashSet<String> names, int D, String[] uid, String[] bid) {
        if(D == bid.length) {
            set.add(new HashSet<>(names));
            return;
        }
        
        for(int i = 0; i < uid.length; i++) {
            if(names.contains(uid[i])) continue;
            
            if(check(uid[i], bid[D])) {
                names.add(uid[i]);
                dfs(names, D + 1, uid, bid);
                names.remove(uid[i]);
            }
            
        }
        
    }
    
    static boolean check(String uid, String bid) {
        if(uid.length() != bid.length()) return false;
        
        for(int i = 0; i < uid.length(); i++) {
            if(bid.charAt(i) != '*' && (uid.charAt(i) != bid.charAt(i))) return false;
        }
        
        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        set = new HashSet<>();
        
        dfs(new HashSet<>(), 0, user_id, banned_id);
        
        
        return set.size();
    }
}