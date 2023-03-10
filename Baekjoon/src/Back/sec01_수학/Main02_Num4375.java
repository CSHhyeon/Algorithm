package Back.sec01_수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02_Num4375
{
	public static void main(String[] args) throws IOException
	{
		//테스트케이스는 3개가 아니다.		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str_input;
		int n = 1;	
		int num = 1;
		while((str_input = bf.readLine()) != null) {
			int input = Integer.parseInt(str_input);
			while((n = n % input) != 0) {
				n = n * 10 + 1;
				num++;
			}
			sb.append(num).append('\n');
			n = num = 1;
		}
		System.out.print(sb);
	}
}
