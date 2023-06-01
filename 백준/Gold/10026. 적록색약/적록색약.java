import java.util.*;
import java.io.*;

class Node{
	private int x;
	private int y;
	
	public Node(int x, int y) {
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
	static Character[][] arr;
	static boolean[][] visited;
	static boolean[][] checked;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int normal = 0;
	static int notNorm = 0;
	
	public static void bfs(int n, int m, char C) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(n, m));
		visited[n][m] = true;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			int x = node.getX();
			int y = node.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
				
				if(arr[nx][ny].equals(C) && !visited[nx][ny]) {
					que.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static void no(int n, int m, char C) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(n, m));
		checked[n][m] = true;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			int x = node.getX();
			int y = node.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
				
				if(C == 'B') {
					if(arr[nx][ny].equals(C) && !checked[nx][ny]) {
						que.offer(new Node(nx, ny));
						checked[nx][ny] = true;
					}
				}
				else {
					if((arr[nx][ny] == 'R' || arr[nx][ny] == 'G') && !checked[nx][ny]) {
						que.offer(new Node(nx, ny));
						checked[nx][ny] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		arr = new Character[N][N];
		visited = new boolean[N][N];
		checked = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = bf.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, arr[i][j]);
					normal++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!checked[i][j]) {
					no(i, j, arr[i][j]);
					notNorm++;
				}
			}
		}
		
		System.out.println(normal + " " + notNorm);
	}

}
