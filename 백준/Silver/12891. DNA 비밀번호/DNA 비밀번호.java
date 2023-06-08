import java.util.*;
import java.io.*;

public class Main {
	public static boolean check(int[] condition, int[] myArr) {
		if(myArr[0] >= condition[0] && myArr[1] >= condition[1] && myArr[2] >= condition[2] && myArr[3] >= condition[3]) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());	// DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken());	// 비밀번호로 사용할 부분문자열의 길이
		
		char[] DNA = bf.readLine().toCharArray();
		int[] condition = new int[4];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			condition[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int[] myArr = new int[4];
		//초기 박스 설정
		for(int i = 0; i < P; i++) {
			if(DNA[i] == 'A') myArr[0]++;
			if(DNA[i] == 'C') myArr[1]++;
			if(DNA[i] == 'G') myArr[2]++;
			if(DNA[i] == 'T') myArr[3]++;
		}
		if(check(condition, myArr)) cnt++;
		
		for(int i = P; i < S; i++) {
			switch(DNA[i]) {
			case 'A':
				myArr[0]++;
				break;
			case 'C':
				myArr[1]++;
				break;
			case 'G':
				myArr[2]++;
				break;
			case 'T':
				myArr[3]++;
				break;
			}
			
			switch(DNA[i - P]) {
			case 'A':
				myArr[0]--;
				break;
			case 'C':
				myArr[1]--;
				break;
			case 'G':
				myArr[2]--;
				break;
			case 'T':
				myArr[3]--;
				break;
			}
			if(check(condition, myArr)) cnt++;
		}
		
		System.out.println(cnt);
	}

}
