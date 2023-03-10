package Back.sec02_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main01_Num2309
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		int two_add = 0;
		sum = sum - 100;	//9명의 합에서 100을 뺀 값
		
		int i = 0, j = 1;
		while(two_add != sum) {
			if(j == 9) {
				i++;
				j = i + 1;
			}
			two_add = arr[i] + arr[j];
			j++;
		}
		
		for(int k = 0; k < 9; k++) {
			if(k == i || k == j - 1) {}
			else {
				System.out.println(arr[k]);
			}
		}
	}
}
