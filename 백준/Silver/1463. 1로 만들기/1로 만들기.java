import java.util.*;
import java.io.*;

public class Main {
	static long[] dp = new long[(int) 1e6 + 1];
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;	//1로 빼기
			
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		}

		System.out.println(dp[N]);
	}

}
