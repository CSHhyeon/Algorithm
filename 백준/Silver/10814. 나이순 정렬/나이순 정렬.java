import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		String[][] arr = new String[N][2];
		
		for(int i = 0; i < N; i++) {
			String input = bf.readLine();
			
			arr[i][0] = input.split(" ")[0];
			arr[i][1] = input.split(" ")[1];
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			int one = Integer.parseInt(o1[0]);
			int two = Integer.parseInt(o2[0]);
			
			return one - two;
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
