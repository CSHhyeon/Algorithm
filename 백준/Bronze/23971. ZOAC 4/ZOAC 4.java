import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x_count = 1, y_count = 1;
        int x = 0, y = 0;
        while(x < W){
            x += (M + 1);
            if(x < W) x_count++;
        }

        while(y < H){
            y += (N + 1);
            if(y < H) y_count++;
        }

        System.out.println(x_count * y_count);
    }
}
