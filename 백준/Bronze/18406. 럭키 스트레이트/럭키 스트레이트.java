import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] input = bf.readLine().toCharArray();
		
		int N = input.length / 2;
		int left = 0;
		int right = 0;
		for(int i = 0; i < input.length; i++) {
			if(i < N) {
				left += input[i] - '0';
			}
			else {
				right += input[i] - '0';
			}
		}
		
		if(left == right) System.out.println("LUCKY");
		else System.out.println("READY");
	}

}
