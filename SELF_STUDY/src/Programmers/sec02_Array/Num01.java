package Programmers.sec02_Array;

import java.util.Arrays;

public class Num01
{
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for(int n = 0; n < answer.length; n++) {
        	int i = commands[n][0];
        	int j = commands[n][1];
        	int k = commands[n][2];
        	
        	int[] out = new int[j - i + 1];
        	for(int m = 0; m < out.length; m++) {
        		out[m] = array[i - 1 + m];
        	}
        	
        	Arrays.sort(out);
        	answer[index++] = out[k - 1];
        }
        
        return answer;
    }

	public static void main(String[] args)
	{
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answer = solution(array, commands);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
