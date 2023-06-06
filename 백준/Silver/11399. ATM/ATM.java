import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 1; i < N; i++) {
			arr[i] += arr[i - 1];
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
	}

}
