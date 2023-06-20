import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(bf.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0 && z == 0) break;

            int[] arr = {x, y, z};
            Arrays.sort(arr);

            if(arr[2] >= arr[0] + arr[1]) sb.append("Invalid");
            else{
                if(x == y && x == z) sb.append("Equilateral");
                else if(x != y && x != z && y != z) sb.append("Scalene");
                else sb.append("Isosceles");
            }

            if(x == 0 && y == 0 && z == 0) break;
            else sb.append('\n');
        }

        System.out.println(sb);
    }
}
