import java.util.*;

class Block {
    char block;
    boolean hit;
    
    public Block(char block, boolean hit) {
        this.block = block;
        this.hit = hit;
    }
}

class Solution {
    static int answer;
    
    static boolean check(List<Block>[] map) {
        boolean flag = false;
        for(int i = 0; i < map.length - 1; i++) {
            int limit = Math.min(map[i].size(), map[i + 1].size());
    
            for(int j = 0; j < limit - 1; j++) {    
                if(map[i].get(j).block == map[i].get(j + 1).block
                   && map[i].get(j).block == map[i + 1].get(j).block
                   && map[i].get(j).block == map[i + 1].get(j + 1).block) {
                    map[i].get(j).hit = true;
                    map[i].get(j + 1).hit = true;
                    map[i + 1].get(j).hit = true;
                    map[i + 1].get(j + 1).hit = true;
                    flag = true;
                }
            }
        }
        if(!flag) return false;
        // System.out.println();
        // for(List<Character> c: v) System.out.println(c.toString());
        
        // for(int i = 0; i < map.length; i++) {
        //     for(int j = 0; j < map[i].size(); j++) System.out.print(map[i].get(j).block + " ");
        //     System.out.println();
        // }
        // System.out.println();
        
        List<Block> tmp = new ArrayList<>();
        for(int i = 0; i < map.length; i++) {
            tmp = new ArrayList<>();
            for(int j = 0; j < map[i].size(); j++) {
                if(map[i].get(j).hit) answer++;
                else tmp.add(map[i].get(j));
            }
            map[i] = tmp;
        }
        return true;
    }
    
    public int solution(int m, int n, String[] board) {
        answer = 0;
      
        List<Block>[] blocks = new List[n];
        for(int i = 0; i < n; i++) blocks[i] = new ArrayList<Block>();
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                blocks[j].add(new Block(board[i].charAt(j), false));
            }
        }
        
        // for(List<Character> c: blocks) System.out.println(c.toString());
        boolean flag = false;
        while(check(blocks));
        
        return answer;
    }
}