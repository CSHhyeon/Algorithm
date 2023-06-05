import java.util.*;
import java.io.*;

class Land{
	private int x;
	private int y;
	
	public Land(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class Main {
	static int[][] cabbage;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void bfs(int a, int b) {
		Queue<Land> que = new LinkedList<>();
		que.offer(new Land(a, b));
		visited[a][b] = true;
		
		while(!que.isEmpty()){
			Land land = que.poll();
			int x = land.getX();
			int y = land.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= cabbage.length || ny < 0 || ny >= cabbage[0].length) continue;
				
				if(cabbage[nx][ny] == 1 && !visited[nx][ny]) {
					que.offer(new Land(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());	//테스트케이스 개수
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int M = Integer.parseInt(st.nextToken());	//배추밭 가로길이
			int N = Integer.parseInt(st.nextToken());	//배추밭 세로길이
			int K = Integer.parseInt(st.nextToken());	//배추 심어져 있는 위치 개수
			
			cabbage = new int[M][N];
			visited = new boolean[M][N];
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(bf.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cabbage[x][y] = 1;
			}
			
			int num = 0;
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < N; k++) {
					if(cabbage[j][k] == 1 && !visited[j][k]) {
						bfs(j, k);
						num++;
					}
				}
			}
			sb.append(num);
			if(i != T - 1) sb.append('\n');
		}
		System.out.println(sb);
	}

}
