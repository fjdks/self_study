package BOJ_15662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static ArrayList<Integer>[] gear;
	
//	static void gear_print(ArrayList<Integer>[] arr) {
//		for (int i = 0; i < T; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.print(arr[i].get(j) + " ");
//			}
//			System.out.println();
//		}
//	}
	
	static ArrayList<Integer> rotation(int num, int d) {
		ArrayList<Integer> tmp = new ArrayList<>();
		
		// 반시계 방향
		if(d == -1) {
			for (int i = 1; i < 8; i++) tmp.add(gear[num].get(i));
			tmp.add(gear[num].get(0));
		}
		// 시계 방향
		else {
			tmp.add(gear[num].get(7));
			for (int i = 0; i < 7; i++) tmp.add(gear[num].get(i));
		}
		
		return tmp;
	}
	
	static void solution(int num, int d) {
		// num 을 기준으로 왼쪽 방향은 num의 3번 극과 num-1의 7번 극 비교, num-1의 3번 극과 num-2의 7번 극 비교...
		// 오른쪽은 num의 7번 극과 num+1의 3번 극 비교, .....
		// 이 때 1번 톱니와 T번 톱니(마지막 톱니)는 예외처리
		
		ArrayList<Integer>[] copy_gear;
		copy_gear = new ArrayList[T];
		for (int i = 0; i < T; i++) copy_gear[i] = new ArrayList<>();
		
		// 맨 처음 기준이 되는 톱니를 회전시킨 배열을 copy_gear에 추가
		copy_gear[num] = rotation(num, d);
		
		// 왼쪽 방향 탐색
		int cur_d = -d;
		boolean flag = true;
		for (int i = num; i >= 1; i--) {
			// 극이 같으면 더 이상 회전하지 않음
			if(!flag) {
				copy_gear[i - 1] = gear[i - 1];
			} else {
				if(gear[i].get(6) == gear[i - 1].get(2)) {
					copy_gear[i - 1] = gear[i - 1];
					flag = false;
				} else {
					// cur_d는 계속 방향이 바뀜
					copy_gear[i - 1] = rotation(i - 1, cur_d);
				}
			}
			cur_d *= -1;
		}
		
		// 오른쪽 방향 탐색
		cur_d = -d;
		flag = true;
		for (int i = num; i < T - 1; i++) {
			if(!flag) {
				copy_gear[i + 1] = gear[i + 1];
			} else {
				if(gear[i].get(2) == gear[i + 1].get(6)) {
					copy_gear[i + 1] = gear[i + 1];
					flag = false;
				} else {
					copy_gear[i + 1] = rotation(i + 1, cur_d);
				}
			}
			cur_d *= -1;
		}

		for (int i = 0; i < T; i++) {
			gear[i] = new ArrayList<>();
			gear[i] = copy_gear[i];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 톱니바퀴 수 T
		T = Integer.parseInt(br.readLine());
		gear = new ArrayList[T];
		for (int t = 0; t < T; t++) {
			gear[t] = new ArrayList<>();
			String line = br.readLine();
			for (int i = 0; i < 8; i++) {
				gear[t].add(line.charAt(i) - '0');
			}
		}
//		System.out.println("----original gear----");
//		gear_print(gear);
//		System.out.println("---------------------");
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int gear_num = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			
			solution(gear_num, direction);
//			System.out.println("=====seq." + (k + 1) + "=====");
//			gear_print(gear);
//			System.out.println("===============");
			
		}
		
//		System.out.println("--------final--------");
//		gear_print(gear);
//		System.out.println("---------------------");

		int cnt = 0;
		for (int t = 0; t < T; t++) {
			if(gear[t].get(0) == 1) cnt++;
		}
		System.out.println(cnt);
	}

}
