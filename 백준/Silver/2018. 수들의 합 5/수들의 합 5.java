import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int num = 0;
		int[] arr = new int[N + 1];		//합 배열
		for(int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + ++num;
		}
		
		int cnt = 0;
		for(int i = N; i >= 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				int sum = arr[i] - arr[j];
				
				if(sum == N) cnt++;
				if(sum > N) break;
			}
		}
		
		System.out.println(cnt);
	}

}
