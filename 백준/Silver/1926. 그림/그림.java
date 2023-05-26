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
	static int queX = 0;
	static int queY = 0;
	static int num = 0;
	static int max = 0;
	
	//상하좌우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
	
	static void bfs(int[][] arr, boolean[][] visited, int x, int y) {
		que.offer(new Node(x, y));
		visited[x][y] = true;
		num++;
		int thisMax = 0;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			queX = node.getX();
			queY = node.getY();
			thisMax++;
			
			for(int i = 0; i < 4; i++) {
				int nX = queX + dx[i];
				int nY = queY + dy[i];
				
				if(nX < 0 || nX >= arr.length || nY < 0 || nY >= arr[0].length) continue;
				
				if(arr[nX][nY] == 1 && !visited[nX][nY]) {
					que.offer(new Node(nX, nY));
					visited[nX][nY] = true;
				}
			}
		}
		
		if(thisMax > max) {
			max = thisMax;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String NM = bf.readLine();
		int N = Integer.parseInt(NM.split(" ")[0]);	//도화지의 세로 크기
		int M = Integer.parseInt(NM.split(" ")[1]); //도화지의 가로 크기
		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1 && !visited[i][j])
				bfs(arr, visited, i, j);
			}
		}
		System.out.println(num);
		System.out.println(max);
	}
}
