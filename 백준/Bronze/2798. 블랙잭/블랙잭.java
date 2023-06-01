import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		st = new StringTokenizer(bf.readLine(), " ");
		
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i = 0; i < M; i++) {
			for(int j = i + 1; j < M; j++) {
				for(int k = j + 1; k < M; k++) {
					int add = arr[i] + arr[j] + arr[k];
					if(add <= max && add > sum) sum = add;
				}
			}
		}
		
		System.out.println(sum);
	}

}
