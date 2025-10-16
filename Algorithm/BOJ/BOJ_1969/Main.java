package BOJ_1969;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static String[] DNAs;
	static int[] count;
	static StringBuilder sb = new StringBuilder();
	
	static void getDNA() {
		for (int i = 0; i < M; i++) {
			count = new int[4]; // ATGC
			for (int j = 0; j < N; j++) {
				CtoI(DNAs[j].charAt(i));
			}
			convert();
		}
	}
	
	static void CtoI(char dna) {
		if(dna == 'A') count[0]++;
		else if(dna == 'C') count[1]++;
		else if(dna == 'G') count[2]++;
		else count[3]++;
	}
	
	static void convert() {
		int max = -1;
		int idx = -1;
		for (int i = 0; i < 4; i++) {
			if(max < count[i]) {
				max = count[i];
				idx = i;
			}
		}
		if(idx == 0) sb.append('A');
		else if(idx == 1) sb.append('C');
		else if(idx == 2) sb.append('G');
		else sb.append('T');
		
	}
	
	
	static int getHammingDistance(String std) {
		int dist = 0; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(std.charAt(j) != DNAs[i].charAt(j)) {
					dist++;
				}
				
			}
		}
		
		return dist;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		DNAs = new String[N];
		for (int i = 0; i < N; i++) DNAs[i] = br.readLine();

		getDNA();
		
		System.out.println(sb);
		System.out.println(getHammingDistance(sb.toString()));
	}

}
