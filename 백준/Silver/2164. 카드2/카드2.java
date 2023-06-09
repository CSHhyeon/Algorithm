import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			que.offer(i);
		}
		
		while(que.size() > 1) {
			que.poll();
			que.offer(que.poll());
		}
		
		System.out.println(que.poll());
	}

}
