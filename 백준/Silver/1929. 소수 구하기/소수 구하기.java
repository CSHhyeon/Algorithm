import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N + 1];
        visited[1] = true;
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= N; j++) {
				if(visited[i] || i * j > N) break;
				
				if(!visited[i * j]) visited[i * j] = true;
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(!visited[i]) System.out.println(i);
		}
	}

}
