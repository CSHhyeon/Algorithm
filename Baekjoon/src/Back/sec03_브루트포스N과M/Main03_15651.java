package Back.sec03_브루트포스N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03_15651 {
	static StringBuilder sb = new StringBuilder();
	static boolean[] check = new boolean[8];
	static int[] input = new int[8];
	
	static void print(int index, int N, int M) {
		if(index == M) {
			for(int i = 0; i < M; i++) {
				sb.append(input[i]);
				if(i != M - 1) sb.append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			input[index] = i;
			print(index + 1, N, M);
			
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		print(0, N, M);
		System.out.println(sb.toString());
	}
}
