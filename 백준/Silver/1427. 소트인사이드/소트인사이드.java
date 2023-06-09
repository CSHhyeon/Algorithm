import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] input = bf.readLine().toCharArray();
		
		Integer[] arr = new Integer[input.length];
		for(int i = 0 ; i < input.length; i++) {
			arr[i] = input[i] - '0';
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		for(int i = 0; i < input.length; i++) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}

}
