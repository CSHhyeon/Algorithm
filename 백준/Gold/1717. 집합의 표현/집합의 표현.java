import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] parent;
	
	// 두 원소가 속한 집합을 합치기
	static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a > b) parent[a] = b;
		else parent[b] = a;
	}
	
	// 특정 원소가 속한 집합을 찾기
	static int findParent(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = findParent(parent[x]);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] input = new int[M][3];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//초기화
		parent = new int[N + 1];
		for(int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			if(input[i][0] == 0) {	//합치기
				unionParent(input[i][1], input[i][2]);
			}
			else {	//찾기
				if(findParent(input[i][1]) == findParent(input[i][2])) sb.append("YES").append('\n');
				else sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
