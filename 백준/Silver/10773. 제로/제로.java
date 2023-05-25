import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//정수 K 받기
		int K = Integer.parseInt(bf.readLine());
		int[] arr = new int[K];
		
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < K; i++) {
			if(arr[i] == 0) stack.pop();
			else stack.push(arr[i]);
		}

		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}

}
