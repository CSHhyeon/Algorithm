import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String NK = bf.readLine();
		int N = Integer.parseInt(NK.split(" ")[0]);	//동전의 종류
		int K = Integer.parseInt(NK.split(" ")[1]);	//가치의 합
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[N - i - 1] = Integer.parseInt(bf.readLine());
		}
		
		int num = 0;
		while(true) {
			if(K == 0) break;
			else {
				for(int i = 0; i < N; i++) {
					if(K >= arr[i]) {
						int n = K / arr[i];
						
						K -= arr[i] * n;	//거스름돈
						num += n;			//사용한 동전 개수
						break;
					}
				}
			}	
		}
		
		System.out.println(num);
	}
}
