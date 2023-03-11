package Programmers.sec01_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num03 {
	//배열 정렬 후 startsWith() 함수 이용
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 1; i < phone_book.length; i++) {
        	if(phone_book[i].startsWith(phone_book[i - 1])) return false;
        }
        return answer;
    }
	
	//정렬시키면 어떻게 출력되는지 보기 위함
	public static boolean solution4(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length; i++) {
        	System.out.println(phone_book[i]);
        }
        //119 97674223 1195524421 -> 119 1195524421 97674223
        //12 567 1235 88 123 -> 12 123 1235 567 88
        
        return answer;
    }
	
	//여전히 런타임 에러
	public static boolean solution3(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i < phone_book.length; i++) {
        	int N = phone_book[i].length();
        	for(int j = i + 1; j < phone_book.length; j++) {
        		if(phone_book[i].charAt(0) == phone_book[j].charAt(0)) {
        			String str = phone_book[j].substring(0, N);
            		if(str.equals(phone_book[i])) return false;
        		}
        	}
        }
      
        return answer;
    }
	
	//런타임 에러
	public static boolean solution2(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i < phone_book.length; i++) {
        	int N = phone_book[i].length();
        	for(int j = i + 1; j < phone_book.length; j++) {
        		String str = phone_book[j].substring(0, N);
        		if(str.equals(phone_book[i])) return false;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String[] phone_book = new String[N];
		for(int i = 0; i < N; i++) {
			phone_book[i] = st.nextToken();
		}
		
		System.out.println(solution(phone_book));
	}
}
