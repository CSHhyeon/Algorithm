import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		char[] input = bf.readLine().toCharArray(); 
		int[] arr = new int[N];
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = input[i] - '0';
			sum += arr[i];
		}

		System.out.println(sum);
	}

}
