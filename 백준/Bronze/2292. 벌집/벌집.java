import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int cnt = 1;
        int num = 2;
        while(num <= N){
            num += (6 * cnt);
            cnt++;
        }

        if(N == 1) System.out.println(1);
        else System.out.println(cnt);
    }
}
