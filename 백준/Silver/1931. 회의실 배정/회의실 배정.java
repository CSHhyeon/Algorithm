
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
				return o1[0] - o2[0];	//종료 시간이 같을 경우 시작 시간이 빠른 순으로 정렬
			}
			else {
				return o1[1] - o2[1];	//종료 시간에 따라 정렬
			}
		});
		
		int num = 1;
		int index = 0;
		for(int i = 1; i < N; i++) {
			if(arr[i][0] >= arr[index][1]) {
				num++;
				index = i;
			}
		}

		System.out.println(num);
	}
}
