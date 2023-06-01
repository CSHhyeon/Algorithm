import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Queue<Integer> que = new LinkedList<>();
	
	public static void dfs(int start, boolean[] visited) {	
		visited[start] = true;
		sb.append(start).append(' ');
		
		for(int i = 0; i < list.get(start).size(); i++) {
			int linked = list.get(start).get(i);
			if(!visited[linked]) dfs(linked, visited);
		}
	}
	
	public static void bfs(int start, boolean[] visited) { //queue 사용
		que.offer(start);
		visited[start] = true;
		sb.append(start).append(' ');
		
		while(!que.isEmpty()) {
			int input = que.poll();
			for(int i = 0; i < list.get(input).size(); i++) {
				int inputList = list.get(input).get(i);
				if(!visited[inputList]) {
					que.offer(inputList);
					visited[inputList] = true;
					sb.append(inputList).append(' ');
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	//정점의 개수
		int M = Integer.parseInt(st.nextToken());	//간선의 개수
		int V = Integer.parseInt(st.nextToken());	//탐색을 시작할 정점의 번호
		
		//그래프 초기화
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i));
		}
		
		boolean[] visitedDFS = new boolean[N + 1];
		boolean[] visitedBFS = new boolean[N + 1];
		dfs(V, visitedDFS);
		sb.append('\n');
		bfs(V, visitedBFS);
		System.out.println(sb);
	}

}
