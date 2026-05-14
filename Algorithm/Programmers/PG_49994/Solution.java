import java.util.*;

class Solution {
    // 상하우좌
    static int[] di = new int[] {-1, 1, 0, 0};
    static int[] dj = new int[] {0, 0, 1, -1};
    static HashSet<String> set = new HashSet<>();
    static int first_road;
    
    static String get_route(int[][] route){
        return route[0][0] + ", " + route[0][1] + ", " + route[1][0] + ", " + route[1][1];
    }
    
    static void task(String commands){
        int[] cur_pos = new int[]{5, 5};
        
        for(int i = 0; i < commands.length(); i++) {
            char com = commands.charAt(i);
            
            String route;
            switch(com){
                case 'U':
                    if(cur_pos[0] == 0) break;
                    
                    route = get_route(new int[][] {{cur_pos[0] - 1, cur_pos[1]}, {cur_pos[0], cur_pos[1]}});
                    if(!set.contains(route)) first_road++;
                    set.add(route);
                    cur_pos[0] -= 1;
                    break;
                case 'D':
                    if(cur_pos[0] == 10) break;
                    
                    route = get_route(new int[][] {{cur_pos[0], cur_pos[1]}, {cur_pos[0] + 1, cur_pos[1]}});
                    if(!set.contains(route)) first_road++;
                    set.add(route);
                    cur_pos[0] += 1;
                    break;
                case 'R':
                    if(cur_pos[1] == 10) break;
                    
                    route = get_route(new int[][] {{cur_pos[0], cur_pos[1]}, {cur_pos[0], cur_pos[1] + 1}});
                    if(!set.contains(route)) first_road++;
                    set.add(route);
                    cur_pos[1] += 1;
                    break;
                case 'L':
                    if(cur_pos[1] == 0) break;
                    
                    route = get_route(new int[][] {{cur_pos[0], cur_pos[1] - 1}, {cur_pos[0], cur_pos[1]}});
                    if(!set.contains(route)) first_road++;
                    set.add(route);
                    cur_pos[1] -= 1;
                    break;

            }
            // System.out.println(first_road);
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        task(dirs);
        
        return first_road;
    }
}