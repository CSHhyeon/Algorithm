import java.util.*;
import java.io.*;

class Node{
	private int x;
	private int y;
	
	public Node(int x, int y){
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
	static Queue<Node> que = new LinkedList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static void bfs(int[][] arr, int[][] visited) {	
		while(!que.isEmpty()) {
			Node node = que.poll();
			int x = node.getX();
			int y = node.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
				
				if(arr[nx][ny] == 0 && visited[nx][ny] == 0) {
					que.offer(new Node(nx, ny));
					visited[nx][ny] = visited[x][y] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());	//상자의 가로 칸의 수
		int N = Integer.parseInt(st.nextToken());	//상자의 세로 칸의 수
		int[][] arr = new int[N][M];
		int[][] visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1) {
					que.offer(new Node(i, j));
				}
			}
		}
		
		bfs(arr, visited);
		
		int max = 0;
		int stop = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0 && visited[i][j] == 0) stop = 1;
				if(visited[i][j] > max) max = visited[i][j];
			}
			if(stop == 1) break;
		}
		
		if(stop == 1) System.out.println(-1);
		else System.out.println(max);
	}
}
