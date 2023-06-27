import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(bf.readLine());    //굴다리의 길이
        int M = Integer.parseInt(bf.readLine());    //가로등의 개수

        int[] location = new int[M];   //가로등의 위치
        st = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < M; i++){
            location[i] = Integer.parseInt(st.nextToken());
        }

        int H = 1;
        boolean found = true;
        while(true){
            found = true;
            if(location[0] - H > 0 || location[M - 1] + H < N) {
                H++;
                continue;
            }

            for(int i = 0; i < M - 1; i++){
                if(location[i] + H < location[i + 1] - H){
                    found = false;
                    break;
                }
            }

            if(found) break;
            else H++;
        }

        System.out.println(H);
    }
}
