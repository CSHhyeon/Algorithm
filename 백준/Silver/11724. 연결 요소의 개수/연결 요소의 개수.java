import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean visited[];
	static int num = 0;
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for(int i = 0; i < list.get(start).size(); i++) {
			int input = list.get(start).get(i);
			if(!visited[input]) dfs(input);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				num++;
			} 
		}
		
		System.out.println(num);
	}

}
