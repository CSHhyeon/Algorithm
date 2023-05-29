import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] result = new int[9];
	static boolean[] visited = new boolean[9];
	
	public static void print(int index, int N, int M, int[] arr) {
		if(index == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]);
				if(i != M-1) sb.append(' ');
			}
			
			sb.append('\n');
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			result[index] = arr[i];
			visited[i] = true;
			print(index + 1, N, M, arr);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		print(0, N, M, arr);
		
		System.out.println(sb);
	}

}