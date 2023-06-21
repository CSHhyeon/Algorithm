import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] S = new int[21];
        int M = Integer.parseInt(bf.readLine());    //수행해야 하는 연산의 수
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            String comment = st.nextToken();
            int x = 0;
            switch (comment){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S[x] = 1;
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S[x] = 0;
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if(S[x] == 1) sb.append(1);
                    else sb.append(0);

                    if(i != M - 1) sb.append('\n');
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if(S[x] == 1) S[x] = 0;
                    else S[x] = 1;
                    break;
                case "all":     //{1, 2, ..., 20}으로 바꾸기
                    Arrays.fill(S, 1);
                    break;
                case "empty":   //공집합으로 바꾸기
                    Arrays.fill(S, 0);
                    break;
            }
        }

        System.out.println(sb);
    }
}
