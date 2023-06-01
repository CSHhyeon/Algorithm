import java.util.*;
import java.io.*;

class Town{
	private int x;
	private int y;
	
	public Town(int x, int y) {
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
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int count = 0;

	static int bfs(int n, int m, int[][] town, boolean[][] visited) {		
		Queue<Town> que = new LinkedList<>();
		que.offer(new Town(n, m));
		visited[n][m] = true;
		
		int num = 1;
		while(!que.isEmpty()) {
			Town t = que.poll();
			int x = t.getX();
			int y = t.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= town.length || ny < 0 || ny >= town[0].length) continue;
				
				if(town[nx][ny] == 1 && !visited[nx][ny]) {
					que.offer(new Town(nx, ny));
					visited[nx][ny] = true;
					num++;
				}
			}
		}
		
		count++;
		return num;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] town = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = bf.readLine();
			
			for(int j = 0; j < N; j++) {
				town[i][j] = line.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(town[i][j] == 1 && !visited[i][j]) list.add(bfs(i, j, town, visited));
			}
		}
		
		System.out.println(count);
		
		Collections.sort(list);
		for(int i = 0; i < count; i++) {
			System.out.println(list.get(i));
		}
	}

}
