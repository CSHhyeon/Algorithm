package Back.sec02_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02_Num3086
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int max = 0;
		String input;
		char[][] arr = new char[N][N];
		char temp;
		
		for(int i = 0; i < N; i++) {
			input = bf.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		//모든 자리마다 바꿔보기(우, 하)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//오른쪽이랑 바꾸기
				if(j != N - 1) {
					temp = arr[i][j]; arr[i][j] = arr[i][j + 1]; arr[i][j + 1] = temp;
					if(check(arr, i, i, j, j + 1) > max) max = check(arr, i, i, j, j + 1);	// 행, 열 체크
					temp = arr[i][j]; arr[i][j] = arr[i][j + 1]; arr[i][j + 1] = temp;	
				}
				
				//아래랑 바꾸기
				if(i != N - 1) {
					temp = arr[i][j]; arr[i][j] = arr[i + 1][j]; arr[i + 1][j] = temp;
					if(check(arr, i, i + 1, j, j) > max) max = check(arr, i, i + 1, j, j);	// 행, 열 체크
					temp = arr[i][j]; arr[i][j] = arr[i + 1][j]; arr[i + 1][j] = temp;	
				}
			}
		}
		System.out.println(max);
		
	}
	
	public static int check(char[][] arr, int row1, int row2, int col1, int col2) {
		int N = arr.length;
		int max = 0;
		int cnt = 1;
		for(int i = row1; i <= row2; i++) {
			cnt = 1;
			for(int j = 0; j < N - 1; j++) {
				if(arr[i][j] == arr[i][j + 1]) {
					cnt++;
				}
				else {
					cnt = 1;
				}
				if(max < cnt) max = cnt;
			}
		}

		for(int j = col1; j <= col2; j++) {
			cnt = 1;
			for(int i = 0; i < N - 1; i++) {
				if(arr[i][j] == arr[i + 1][j]) {
					cnt++;
				}
				else {
					cnt = 1;
				}
				if(max < cnt) max = cnt;	
			}
		}
		
		return max;
	}
}
