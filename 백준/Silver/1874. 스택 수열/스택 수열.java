import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(bf.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		boolean NO = false;
		
		int num = 1;
		int index = 0;
		while(index <= N - 1) {
			if(stack.isEmpty()) {
				stack.push(num++);
				sb.append("+").append('\n');
			}
			
			if(stack.peek() == arr[index]) {
				stack.pop();
				sb.append("-");
				if(index != N - 1) sb.append('\n');
				index++;
			}
			else {
				if(stack.peek() > arr[index]) {
					NO = true;
					break;
				}
				else {
					stack.push(num++);
					sb.append("+").append('\n');
				}
			}
		}
		
		if(NO) System.out.println("NO");
		else System.out.println(sb);
	}

}
