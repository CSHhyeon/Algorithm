import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = bf.readLine();

        boolean[] visited = new boolean[N];
        char[] table = new char[N];
        for(int i = 0; i < N; i++){
            table[i] = input.charAt(i);
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(table[i] == 'P'){
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N - 1);
                for(int j = start; j <= end; j++){
                    if(table[j] == 'H' && !visited[j]){
                        visited[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
