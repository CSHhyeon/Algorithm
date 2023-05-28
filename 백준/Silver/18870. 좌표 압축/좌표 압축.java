import java.util.*;
import java.io.*;

public class Main {
	public static int lowerBound(int[] arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= target) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(bf.readLine());
		int[] find = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			find[i] = Integer.parseInt(st.nextToken()); 
			map.put(find[i], i);
		}
		
		int index = 0;
		int[] arr = new int[map.size()];
		for(int key : map.keySet()) {
			arr[index] = key;
			index++;
		}
		
		Arrays.sort(arr);
		
		
		for(int i = 0; i < N; i++) {
			sb.append(lowerBound(arr, find[i], 0, map.size())).append(' ');
		}

		System.out.println(sb);
	}
}
