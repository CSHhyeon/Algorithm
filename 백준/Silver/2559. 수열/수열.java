import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); //온도를 측정한 전체 날짜의 수
        int k = Integer.parseInt(st.nextToken()); //합을 구하기 위한 연속적인 날짜의 수
        
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        int max = -10000001;
        for (int i = k; i <= n; i++) {
            int rangeSum = arr[i]-arr[i-k];
            if (max < rangeSum) max = rangeSum;
        }
        System.out.println(max);
	}

}
