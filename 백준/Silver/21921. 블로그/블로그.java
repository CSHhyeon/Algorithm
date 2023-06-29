import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   //블로그를 시작하고 지난 일수
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine(), " ");
        int[] visit = new int[N];
        for(int i = 0; i < N; i++){
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N - X + 1];
        int index = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            if(i < X){
                sum[0] += visit[i];
                max = sum[0];
                map.put(sum[0], 1);
            }
            else{
                index++;
                sum[index] = sum[index - 1] + visit[i] - visit[i - X];
                if(max < sum[index]) max = sum[index];
                map.put(sum[index], map.getOrDefault(sum[index], 0) + 1);
            }
        }

        if(max == 0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(map.get(max));
        }
    }
}

