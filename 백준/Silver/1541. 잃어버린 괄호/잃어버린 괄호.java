import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//input[i].split("+")이라고 하면 인식 못한다. 즉, "[+]"로 할 것
		int result = 0;
		String[] input = bf.readLine().split("-");
		for(int i = 0; i < input.length; i++) {
			int sum = 0;
			String[] cal = input[i].split("[+]");
			for(int j = 0; j < cal.length; j++) {
				sum += Integer.parseInt(cal[j]);
			}
			
			if(i == 0) result = sum;
			else result -= sum;
		}
		
		System.out.println(result);
	}

}
