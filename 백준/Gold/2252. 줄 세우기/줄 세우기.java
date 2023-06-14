import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	//학생들의 번호 : 1~N
		int M = Integer.parseInt(st.nextToken());	//키를 비교한 횟수

		int[] num = new int[N + 1];
		boolean[] visited = new boolean[N + 1];		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		//setting
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list.get(A).add(B);
			num[B]++;
		}
		
		//세팅 활용
		int cnt = 0;
		int index = 1;
		while(cnt < N) {
			if(index > N) index = 1;
			
			if(!visited[index] && num[index] == 0) {
				cnt++;
				visited[index] = true;
				sb.append(index);
				if(cnt != N) sb.append(' ');
					
				for(int i = 0; i < list.get(index).size(); i++) {
					int input = list.get(index).get(i);
					num[input]--;
				}
			}
			
			index++;
		}
		
		System.out.println(sb);
	}

}
