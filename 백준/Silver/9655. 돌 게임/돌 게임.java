import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        boolean sang = false;
        while(N > 0){
            if(N % 3 == 0) N -= 3;
            else N -= 1;

            if(sang) sang = false;
            else sang = true;
        }

        if(sang) System.out.println("SK");
        else System.out.println("CY");
    }
}
