import java.util.*;
import java.io.*;

public class Main {
	//모듈러 연산 (a*b) % C = (a%c * b%c) 사용
	//ex) 10^11 % 12 = {(10^5) * (10^5) * 10} % 12 = (10^5)%12 * (10^5)%12 * 10%12 
	//즉, pow(a, n)이 있을 때 n = 0이면 pow(a, n) = 1
	//n = 짝수이면 pow(a, n) = pow(a, n/2)^2
	//n = 홀수이면 pow(a, n) = pow(a, n/2)^2 * a
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A, B, C));
	}
	
	public static long pow(int A, int B, int C) {
		if(B == 0) return 1;
		
		long n = pow(A, B / 2, C);
		if(B % 2 == 0) {
			return (n * n) % C;
		}
		else {
			return (((n * n) % C) * A) % C;
		}
		
	}

}
