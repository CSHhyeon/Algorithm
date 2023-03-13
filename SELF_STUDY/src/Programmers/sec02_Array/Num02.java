package Programmers.sec02_Array;

import java.util.Arrays;

public class Num02
{
	static StringBuilder sb = new StringBuilder();
	public static String solution(int[] numbers) {
        //String answer = "";
        String[] arr = new String[numbers.length];
        
        //int -> String
        for(int i = 0; i < numbers.length; i++) {
        	arr[i] = Integer.toString(numbers[i]);
        }
        
        //arr안의 인자 o1, o2를 비교할 때 o2+o1과 o1+o2 중 더 큰 값을 return
        //앞에서부터 2개씩 비교하는게 맞다! Arrays.sort를 했기 때문에 compareTo의 규칙에 맞게 정렬이 완료될때까지 반복해서 정렬시킨다.
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        //0이 포함될 수 있다. 0이 중복일 경우 000이 답이 나오면 안된다. 0으로만 출력하게!
        if(arr[0].equals("0")) return "0";
        
        for(int i = 0; i < arr.length; i++) {
        	//System.out.println("arr[" + i + "] = " + arr[i]);
        	sb.append(arr[i]);
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args)
	{
		int[] num1 = {6, 10, 2};
		System.out.println(solution(num1));
		
		int[] num2 = {3, 30, 34, 5, 9};
		System.out.println(solution(num2));
	}
}

/*
Integer[] num = {6, 10, 2};
Arrays.sort(num, Collections.reverseOrder()); 해본 결과
[6, 10, 2] -> [10, 6, 2]
[3, 30, 34, 5, 9] -> [34, 30, 9, 5, 3]
[3, 30, 38, 26, 5, 9] -> [38, 30, 26, 9, 5, 3]

만들어야 하는 것
[3, 30, 34, 5, 9] -> [9, 5, 34, 3, 30]
34 3 30
한 자리수인 경우 33으로 인식하게 하자.

ex)
[3, 30, 32, 33, 35, 38, 39] -> [39, 38, 35, 33, 3, 32, 30]
[331, 333, 335, 31, 33, 35, 3] -> [35, 335, 33, 333, 331, 3, 31]
첫번째 자리수 비교 -> 두번째 자리수 비교
-----------------------------------
a.compareTo(b) : 앞에서부터 비교하다 다른 문자열이 나오면 'a - b' 순서로 해당 문자의 아스키코드 값을 뺀 결과(int)를 리턴
내림차순 : (o2+o1).compareTo(o1+o2)
오름차순 : (o1+o2).compareTo(o1+o2)
---------------------------------
도저히 안되겠어서 구글링!
모든 입력값을 String으로 바꾼다.
내림차순으로 비교를 하는데 예를 들어, 3 30이 있을 때 330과 303을 비교해 330이 더 크니 330을 리턴하는 형식으로 이어 붙이는 것!
[3, 30, 34, 5, 9] 로 예를 들자면
330 303 비교 - 330이 더 크니 330으로 합침
33034 34330 비교 - 34330이 더 크니 34330으로 합침
534330 343305 비교 - 534330이 더 크니 534330으로 합침
9534330 5343309 비교 - 9534330이 더 크니 9534330으로 출력

compareTo 문자열 비교 - 같은 문자열은 숫자와 동일하게 0을 리턴

*/