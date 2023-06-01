import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited = new boolean[101];
	static int num = 0;
	
	static void dfs(int x) {
		visited[x] = true;
		num++;
		
		for(int i = 0; i < list.get(x).size(); i++) {
			int y = list.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());	//컴퓨터의 수
		int M = Integer.parseInt(bf.readLine());	//네트워크 상에 직접 연결되어 있는 컴퓨터 쌍의 수
		
		//배열 초기화
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
		
		dfs(1);
		System.out.println(num - 1);
	}

}
