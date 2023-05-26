import java.util.*;
import java.io.*;

class Node {
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
	static Queue<Node> que = new LinkedList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
 	public static int bfs(int[][] arr, int[][] visited) {
 		que.offer(new Node(0, 0));
 		
 		while(!que.isEmpty()) {
 			Node node = que.poll();
 			int x = node.getX();
 			int y = node.getY();
 			
 			for(int i = 0; i < 4; i++) {
 				int nx = x + dx[i];
 				int ny = y + dy[i];
 				
 				if(nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
 				
 				if(arr[nx][ny] == 1) {
 					if(visited[nx][ny] == 0) {
 						visited[nx][ny] = visited[x][y] + 1;
 						que.offer(new Node(nx, ny));
 					}
 					else {
 						int newLength = visited[x][y] + 1;
 						if(newLength < visited[nx][ny]) visited[nx][ny] = newLength;
 					}
 				}
 			}
 		}
 		
 		return visited[arr.length - 1][arr[0].length - 1];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String NM = bf.readLine();
		int N = Integer.parseInt(NM.split(" ")[0]);
		int M = Integer.parseInt(NM.split(" ")[1]);
		int[][] arr = new int[N][M];
		int[][] visited = new int[N][M];
		visited[0][0] = 1;
		
		for(int i = 0; i < N; i++) {
			String input = bf.readLine();
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(arr, visited));
	}
}
