import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		Integer[] arr = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int sorted : arr) {
			sb.append(sorted).append('\n');
		}
		
		System.out.println(sb);
	}
}