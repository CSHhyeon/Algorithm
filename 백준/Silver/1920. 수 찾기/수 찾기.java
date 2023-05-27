import java.util.*;
import java.io.*;

public class Main {
	public static int find(int[] arr, int find, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == find) return 1;
			else if(arr[mid] > find) end = mid - 1;
			else start = mid + 1;
		}
		
		return 0;
	}

	public static void main(String[] args) throws IOException{
		 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 int N = Integer.parseInt(bf.readLine());	//주어지는 정수
		 
		 int[] arr = new int[N];
		 st = new StringTokenizer(bf.readLine(), " ");
		 for(int i = 0; i < N; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 Arrays.sort(arr);
		 
		 int M = Integer.parseInt(bf.readLine());	//찾아야 하는 정수 배열
		 
		 int[] find = new int[M];
		 st = new StringTokenizer(bf.readLine(), " ");
		 for(int i = 0; i < M; i++) {
			 find[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 //결과 출력
		 for(int i = 0; i < M; i++) {
			 System.out.println(find(arr, find[i], 0, N - 1));
		 }
	}
}
