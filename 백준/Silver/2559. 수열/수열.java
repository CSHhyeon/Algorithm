import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	//온도를 측정한 전체 날짜의 수
		int K = Integer.parseInt(st.nextToken());	//합을 구하기 위한 연속적인 날짜의 수
		
		st = new StringTokenizer(bf.readLine(), " ");
		int[] temp = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			temp[i] = temp[i - 1] + Integer.parseInt(st.nextToken());
		}

		//부분합 구하기
		int max = Integer.MIN_VALUE;
		for(int i = K; i <= N; i++) {
			int rangeSum = temp[i] - temp[i - K]; 
			if(rangeSum > max) max = rangeSum;
		}
		
		System.out.println(max);
	}

}
