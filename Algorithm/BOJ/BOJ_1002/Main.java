package BOJ_1002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int x1, y1, r1, x2, y2, r2; 
	
	static double get_distance(int x1, int y1, int x2, int y2) {
		double dis = 0;
		dis = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
		
		return dis;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int ans = 0;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			double dis = get_distance(x1, y1, x2, y2);
			
			if(dis == 0) {
				if(r1 != r2) ans = 0;
				else ans = -1;
			}
			else if(r1 + r2 < dis) ans = 0;
			else if(r1 + r2 == dis) ans = 1;
			else if(r1 + r2 > dis) {
				if(Math.abs(r1 - r2) == dis) ans = 1;
				else if(Math.abs(r1 - r2) > dis) ans = 0;
				else ans = 2;
			}


			
			System.out.println(ans);
		}
	}

}
