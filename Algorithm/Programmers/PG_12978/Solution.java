import java.util.*;

class Solution {
    static boolean[] v;
    static ArrayList<Node>[] list;
    
    static class Node {
        int end;
        int cost;
        
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();
            
        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        dist[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {

            Node cur = pq.poll();

            if(cur.cost > dist[cur.end]) continue;
            for(Node next : list[cur.end]) {
                int newCost = cur.cost + next.cost;
                if(newCost < dist[next.end]) {
                    dist[next.end] = newCost;
                    pq.add(new Node(next.end, newCost));
                }
            }
        }


        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}