package BOJ_1358;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int W, H, X, Y, P;
	static int[][] players;
	
	static double get_dis(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		players = new int[P][2];
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			players[i][0] = Integer.parseInt(st.nextToken());
			players[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for (int i = 0; i < P; i++) {
			if(X <= players[i][0] && players[i][0] <= X + W && Y <= players[i][1] && players[i][1] <= Y + H) cnt++;
			else if(get_dis(players[i][0], players[i][1], X, Y + H/2) <= H/2 || get_dis(players[i][0], players[i][1], X + W, Y + H/2) <= H/2) cnt++;
		}
		System.out.println(cnt);
	}

}
