package Back.sec02_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03_1476
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int E = Integer.parseInt(st.nextToken());	//1~15
		int S = Integer.parseInt(st.nextToken());	//1~28
		int M = Integer.parseInt(st.nextToken());	//1~19
		int num = 0;

		while(true) {
			num++;
			if((num-E)%15 == 0 && (num-S)%28==0 &&(num-M)%19==0) break;
		}
		System.out.println(num);
	}
}
