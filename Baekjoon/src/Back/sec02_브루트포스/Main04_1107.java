package Back.sec02_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04_1107
{
	public static void main(String[] args)throws IOException
	{
		boolean[] broke = new boolean[10];
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());	//수빈이가 이동하려고 하는 채널
		int M = Integer.parseInt(bf.readLine());	//고장난 버튼의 개수
		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i < M; i++) {	//고장난 버튼
			arr[i] = Integer.parseInt(st.nextToken());
			broke[arr[i]] = true;
		}

		int L = (int)(Math.log10(N) + 1);	//자리수 구하기
		int tenL = (int)Math.pow(10, L - 1);
		int[] arrL = new int[L];	//자리수마다 배열에 넣기
		for(int i = 0; i < L; i++) {
			arrL[i] = N / tenL;
			N = N % tenL;
			tenL = tenL / 10;
		}
		
		int num = 0;
		int[] min = new int[L];
		int[] max = new int[L];
		//잘 되는 버튼들로 구해내는 가장 가까운 작은 수
		for(int i = 0; i < L; i++) {
			if(!broke[arrL[i]]) {
				min[i] = arr[i];
				max[i] = arrL[i];
			}
			else {
				//버튼이 고장났다면
				while(!broke[arr[i]]) {
					
				}
			}
			
		}
		
		//잘 되는 버튼들로 구해내는 가장 가까운 큰 수
		//예외 경우.. 큰 수가 9999가 안될 때 10000이 되어야 한다.
	}
}

/*
arrL은 입력한 값의 각 자리의 수들
res는 버튼 누르는 수!
80000을 예로 들면 예는 8, 9가 고장났다.
최대값, 최소값을 구해야 할 것 같다. 80000에서 가능한 최소는 77777, 가능한 최대는 100000
arr[] = {8, 0, 0, 0, 0}
0~9까지 수를 확인하는데 

입력된 숫자로부터 가까운 수 중에서 고장난 버튼(boolean 사용)이 아닌 것을 선택
반올림 이용하면 위에서 하는거랑 아래에서 하는 거 중 뭐가 더 유리한지 알 수 있지 않을까

*/
