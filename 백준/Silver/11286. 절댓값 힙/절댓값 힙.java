import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			} 
			
			return Math.abs(o1) - Math.abs(o2);
		});
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(bf.readLine());
			if(input == 0) {
				if(que.isEmpty()) sb.append(0).append('\n');
				else sb.append(que.poll()).append('\n');	
			}
			else {
				que.offer(input);
			}
		}
		
		System.out.println(sb);
	}

}
