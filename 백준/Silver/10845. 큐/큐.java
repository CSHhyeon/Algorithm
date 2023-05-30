import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> que = new ArrayDeque<>();
		int N = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			switch(st.nextToken()){
			case "push":
				que.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(que.isEmpty()) sb.append(-1).append('\n');
				else sb.append(que.poll()).append('\n');
				break;
			case "size":
				sb.append(que.size()).append('\n');
				break;
			case "empty":
				if(que.isEmpty()) sb.append(1).append('\n');
				else sb.append(0).append('\n');
				break;
			case "front":
				if(que.isEmpty()) sb.append(-1).append('\n');
				else sb.append(que.peek()).append('\n');
				break;
			case "back":
				if(que.isEmpty()) sb.append(-1).append('\n');
				else sb.append(que.peekLast()).append('\n');
				break;
			}
		}
		
		System.out.println(sb);
	}

}
