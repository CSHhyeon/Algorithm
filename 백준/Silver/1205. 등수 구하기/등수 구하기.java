import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());	//태수의 새로운 점수
		int P = Integer.parseInt(st.nextToken());
		
		if(N == 0) {
			System.out.println(1);
		}
		else {
			Integer[] score = new Integer[N];
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(score, Collections.reverseOrder());
			
			if(N == P && score[N - 1] >= newScore) System.out.println(-1);
			else {
				int rank = 1;
				for(int i = 0; i < N; i++) {
					if(score[i] > newScore) rank++;
					else break;
				}
				
				System.out.println(rank);
			}
		}
	}
}
