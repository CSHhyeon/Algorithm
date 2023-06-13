import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static boolean no = false;
	static boolean visited[];
	static int check[];
	
	public static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		visited[x] = true;
		check[x] = 0;
		
		while(!que.isEmpty()) {
			int input = que.poll();
			
			for(int i = 0; i < list.get(input).size(); i++) {
				int y = list.get(input).get(i);
				
				if(!visited[y]) {
					que.offer(y);
					visited[y] = true;
					check[y] = (check[input] + 1) % 2;					
				}
				else {
					if(check[input] == check[y]) {
						no = true;
						break;
					}
				}
			}
			
			if(no) break;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(bf.readLine());	//테스트케이스의 개수
		
		for(int i = 0; i < K; i++) {
			no = false;
			st = new StringTokenizer(bf.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());	//정점의 개수
			int E = Integer.parseInt(st.nextToken());	//간선의 개수
			
			list = new ArrayList<>();
			visited = new boolean[V + 1];
			check = new int[V + 1];
			
			for(int j = 0; j <= V; j++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int j = 0; j < E; j++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.get(x).add(y);
				list.get(y).add(x);
			}
			
			for(int j = 1; j <= V; j++) {
				if(!visited[j] && !no)	bfs(j);
			}
			
			if(no) System.out.println("NO");
			else System.out.println("YES");
		}
	}

}
