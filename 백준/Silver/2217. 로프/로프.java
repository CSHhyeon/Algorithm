

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Integer[] arr = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());	//내림차순 정렬
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			int num = arr[i] * (i + 1);
			if(num > max) max = num;
		}
		
		System.out.println(max);

	}

}
