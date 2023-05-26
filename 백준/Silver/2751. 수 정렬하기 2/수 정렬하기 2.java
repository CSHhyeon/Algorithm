import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int sorted : arr) {
			sb.append(sorted).append('\n');
		}
		
		System.out.println(sb);
	}
}

//Arrays.sort()보다는 Collections.sort()가 더 빠르다.
// 출력 시 매번 println을 하는 것보다는 StringBuilder를 사용하는 것이 더 빠르고 for(int sorted : arr)로 하는 것이 빠르다.

//Collections.sort 예시
/*
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
 */
