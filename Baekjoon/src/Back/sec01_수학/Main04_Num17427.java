package Back.sec01_수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main04_Num17427
{	
	public static void main(String[] args)throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(bf.readLine());
		long sum = 0;
		
		for(int i = 1; i <= N; i++) {
			sum += i * (N / i);
		}
		
		System.out.println(sum);
	}
}


 