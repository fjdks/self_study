package BOJ_1925;

import java.io.*;
import java.util.*;

public class Main {
	
	static double getLenSquare(int[] p1, int[] p2) {
		return Math.pow((p2[0] - p1[0]), 2) + Math.pow((p2[1] - p1[1]), 2);
	}
	
	static void check(double A, double B, double max) {
		if(A + B == max) System.out.println("JikkakTriangle");
		else if(A + B > max) System.out.println("YeahkakTriangle");
		else System.out.println("DunkakTriangle");
	}
	
	static void check2(double A1, double A2, double B) {
		if(A1 + A2 == B) System.out.println("Jikkak2Triangle");
		else if(A1 + A2 > B) System.out.println("Yeahkak2Triangle");
		else System.out.println("Dunkak2Triangle");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] points = new int[3][2];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		
		if((points[0][1] - points[1][1]) * (points[1][0] - points[2][0]) == (points[1][1] - points[2][1]) * (points[0][0] - points[1][0])) System.out.println("X");
		else {
			double AA = getLenSquare(points[0], points[1]);
			double BB = getLenSquare(points[1], points[2]);
			double CC = getLenSquare(points[2], points[0]);
			
			if(AA == BB && BB == CC) System.out.println("JungTriangle");
			else if(AA == BB || BB == CC || CC == AA) {
				if(AA == BB) check2(AA, BB, CC);
				else if(BB == CC) check2(BB, CC, AA);
				else check2(CC, AA, BB);
			} else {
				if(AA >= BB && AA >= CC) check(BB, CC, AA);
				else if(BB >= CC && BB >= AA) check(CC, AA, BB);
				else check(AA, BB, CC);
			}
			
		}
		
		
	}

}
