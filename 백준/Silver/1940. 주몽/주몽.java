import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());	//재료의 개수
		int M = Integer.parseInt(bf.readLine());	//갑옷을 만드는데 필요한 수
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int[] arr = new int[N];	  //재료들이 가진 고유한 번호들
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				int sum = arr[i] + arr[j];
				
				if(sum == M) cnt++;
				if(sum > M) break;
			}
		}
		
		System.out.println(cnt);
	}

}
