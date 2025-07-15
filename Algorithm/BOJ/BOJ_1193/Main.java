package BOJ_1193;

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<int[]> nums = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());

		int level = 1;
		for (int i = 1; i <= X; i++) {
			if(i == 1) {
				nums.add(new int[] {1});
				level++;
			}
			else {
				if(i == (nums.get(nums.size() - 1)[0] + level - 1)) {
					int[] list = new int[level];
					for (int j = 0; j < level; j++) list[j] = j + i;
					nums.add(list);
					level++;
				}
			}
		}
		
		int size = nums.size();
		// (분자 + 분모) = nums 리스트의 사이즈 + 1
		// (분자 + 분모)가 홀수인 집합은 분자가 오름차순, 짝수인 집합은 분모가 오름차순
		int numerator = 1;
		for (int i = 0; i < size; i++) {
			if (nums.get(size - 1)[i] == X) {
				if((size + 1) % 2 == 1) System.out.println(numerator + "/" + (size + 1 - numerator));
				else System.out.println((size + 1 - numerator) + "/" + numerator);
			} else numerator++;
		}
	}
}
