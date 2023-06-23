import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   //국가의 수
        int K = Integer.parseInt(st.nextToken());   //등수를 알고 싶은 국가

        int[][] arr = new int[N][4];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]){
                if(o1[2] == o2[2]) return o2[3] - o1[3];
                else return o2[2] - o1[2];
            }
            else return o2[1] - o1[1];
        });

        if(arr[0][0] == K) System.out.println(1);
        else{
            int index = 1;
            for(int i = 1; i < N; i++){
                if(arr[i][0] == K){
                    if(arr[i - 1][1] == arr[i][1] && arr[i - 1][2] == arr[i][2] && arr[i - 1][3] == arr[i][3]) break;
                    else{
                        index++;
                        break;
                    }
                }
                if(arr[i - 1][1] == arr[i][1] && arr[i - 1][2] == arr[i][2] && arr[i - 1][3] == arr[i][3]) continue;

                index++;
            }

            System.out.println(index);
        }
    }
}
