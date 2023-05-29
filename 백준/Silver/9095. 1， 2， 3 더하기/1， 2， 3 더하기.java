import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] dp = new int[1000000];
	public static void addNum(int N) {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		sb.append(dp[N]).append('\n');
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			addNum(arr[i]);
		}

		System.out.println(sb);
	}

}
