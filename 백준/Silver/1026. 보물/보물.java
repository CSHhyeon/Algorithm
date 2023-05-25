

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bf.readLine());
		
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];
		
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		int S = 0;
		for(int i = 0; i < N; i++) {
			S += A[i] * B[i];
		}
		
		System.out.println(S);

	}
}
