import java.util.*;

public class Node {
    int i;
    int j;
    int dir;
    int cost;
    
    public Node(int i, int j, int dir, int cost) {
        this.i = i;
        this.j = j;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    static int[] di = new int[]{-1, 0, 1, 0};
    static int[] dj = new int[]{0, 1, 0, -1};
    static boolean[][][] v;
    
    static int bfs(int N, int[][] board) {
        Queue<Node> pq = new LinkedList<>();
        
        pq.add(new Node(0, 0, -1, 0));
        // v[0][0][-1] = true;
        int min_cost = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.i == N - 1 && cur.j == N - 1) min_cost = Math.min(min_cost, cur.cost);
            for(int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                if(0 <= ni && ni < N && 0 <= nj && nj < N && board[ni][nj] != 1) {
                    int ncost = cur.cost;
                    if(cur.dir == -1 || cur.dir == d) ncost += 100;
                    else ncost += 600;
                    
                    if(!v[ni][nj][d] || board[ni][nj] >= ncost) {
                        pq.add(new Node(ni, nj, d, ncost));
                        board[ni][nj] = ncost;
                        v[ni][nj][d] = true;
                    }
                    
                }
            }
        }
        return min_cost;
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        
        v = new boolean[board.length][board.length][4];
        answer = bfs(board.length, board);
        return answer;
    }
}