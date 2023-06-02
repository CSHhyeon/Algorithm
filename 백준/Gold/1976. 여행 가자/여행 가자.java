import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	static int findParent(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = findParent(parent[x]);
	}
	
	static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a > b) parent[a] = b;
		else parent[b] = a;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());	//도시의 수
		int M = Integer.parseInt(bf.readLine());	//여행 계획에 속한 도시들의 수
		
		int[][] arr = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			for(int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//초기화
		parent = new int[N + 1];
		for(int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		
		//여행 계획
		int[] travel = new int[M];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < M; i++) {
			travel[i] = Integer.parseInt(st.nextToken());
		}
		
		//union
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(arr[i][j] == 1) unionParent(i, j);
			}
		}
		
		String result = "NO";
		for(int i = 0; i < M - 1; i++) {
			if(findParent(travel[i]) == findParent(travel[i + 1])) result = "YES";
			else {
				result = "NO";
				break;
			}
		}
		
		System.out.println(result);
	}

}
