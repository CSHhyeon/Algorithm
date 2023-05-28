import java.util.*;
import java.io.*;

public class Main {
	public static int lowerBound(int[] arr, int find, int start, int end) {
		while(start < end) {
			int mid =(start + end) / 2;
			
			if (arr[mid] >= find) end = mid;
            else start = mid + 1;
		}
		
		return end;
	}
	
	public static int upperBound(int[] arr, int find, int start, int end) {
		while(start < end) {
			int mid =(start + end) / 2;
			
			if (arr[mid] > find) end = mid;
            else start = mid + 1;
		}
		
		return end;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());	//가지고 있는 숫자의 개수
		int[] arr = new int[N];						//숫자 카드에 적혀있는 정수
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//이진 탐색을 사용하기 위한 정렬
		Arrays.sort(arr);
		
		int M = Integer.parseInt(bf.readLine());	
		int[] find = new int[M];						//몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr, find[i], 0, N) - lowerBound(arr, find[i], 0, N)).append(' ');
		}
		
		System.out.println(sb);

	}
}
