import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String input = bf.readLine();
			
			arr[i][0] = Integer.parseInt(input.split(" ")[0]);
			arr[i][1] = Integer.parseInt(input.split(" ")[1]);
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			else {
				return o1[1] - o2[1];
			}
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
