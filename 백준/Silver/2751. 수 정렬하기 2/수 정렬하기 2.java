import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(bf.readLine()));
		}
		
		Collections.sort(arr);	//속도가 빠르다고 함.
		
		for(int sorted : arr) {
			sb.append(sorted).append('\n');
		}
		
		System.out.println(sb);
	}
}
