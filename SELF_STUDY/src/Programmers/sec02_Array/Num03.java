package Programmers.sec02_Array;

import java.util.Arrays;

public class Num03 {
	public static int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
        	int h = citations.length - i;	//해당 논문보다 인용횟수가 크거나 같은 논문 편수
        	
        	if(citations[i] >= h) {
        		return h;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};	//3
		//int[] citations = {25, 8, 5, 3, 3};
		//int[] citations = {2};
		//int[] citations = {0};
		System.out.println(solution(citations));
	}
}

/*
배열 정렬한 후 , 그 위로 몇 편 있는지 확인하면 될 듯
[3, 0, 6, 1, 5] -> [0, 1, 3, 5, 6]
0 - 0보다 인용횟수가 크거나 같은 논문 편수 = h = 5  5회 이상 인용된 논문 편수가 5편 이상이다 false
1 - 1보다 인용횟수가 크거나 같은 논문 편수 = h = 4  4회 이상 인용된 논문 편수가 4편 이상이다 false
3 - 3보다 인용횟수가 크거나 같은 논문 편수 = h = 3  3회 이상 인용된 논문 편수가 3편 이상이다 true - h회 이상 인용된 논문 편수가 cit.length - i번 이상이다.
5 - 5보다 인용횟수가 크거나 같은 논문 편수 = h = 2  2회 이상 인용된 논문 편수가 2편 이상이다 true
6 - 6보다 인용횟수가 크거나 같은 논문 편수 = h = 1  1회 이상 인용된 논문 편수가 1편 이상이다 true

*/