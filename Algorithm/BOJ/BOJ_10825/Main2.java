package BOJ_10825;

import java.io.*;
import java.util.*;

public class Main2 {
	
	static class Student implements Comparable<Student> {
		String name;
		int kor;
		int eng;
		int math;
		
		Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		@Override
		public int compareTo(Student o) {
			if(this.kor != o.kor) return Integer.compare(o.kor, this.kor);
			if(this.eng != o.eng) return Integer.compare(this.eng, o.eng);
			if(this.math != o.math) return Integer.compare(o.math, this.math);
			return this.name.compareTo(o.name);
		}
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Student> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			pq.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		while(!pq.isEmpty()) sb.append(pq.poll().name).append("\n");
		System.out.println(sb);
		
		
	}

}
