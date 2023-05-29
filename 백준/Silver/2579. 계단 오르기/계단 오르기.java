import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] stairs = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(bf.readLine()); 
		}
		
		dp[1] = stairs[1];
		
		for (int i = 2; i <= N; i++) {
            if(i == 2){
                dp[2] = stairs[1] + stairs[2];
            }else if(i == 3){
                dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
            }else{
                dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
            }
        }
		
		System.out.println(dp[N]);
	}
}
