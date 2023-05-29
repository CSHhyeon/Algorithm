import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static StringBuilder sb = new StringBuilder();
	static boolean check[] = new boolean[9];
	static int input[] = new int[9];

	static void print(int index, int N, int M) {
		if(index == M) {
			for(int i = 0; i < M; i++) {
				sb.append(input[i]);
				if(i != M - 1) sb.append(" ");
			}
			sb.append('\n');
		}
		
		for(int i = 1; i <= N; i++) {
			if(check[i]) continue;
			else {
				input[index] = i;
				check[i] = true;
				print(index + 1, N, M);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		print(0, N, M);
		System.out.println(sb.toString());
	}
}