import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][N + 1];  //i개 중 j개 뽑는 것

        //초기화! dp[i][1] = i, dp[i][0] = 1, dp[i][i] = 1
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0) dp[i][0] = 1;
                if(j == 1) dp[i][1] = i;
                if(j == i) dp[i][i] = 1;
            }
        }

        //점화식 사용! dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        for(int i = 2; i < dp.length; i++){
            for(int j = 2; j <= i; j++){
                if(dp[i][j] == 0){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
