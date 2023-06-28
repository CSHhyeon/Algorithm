import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());    //도시의 개수
        int[] distance = new int[N - 1];
        int[] price = new int[N];

        st = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < N - 1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int min_index = 0;
        st = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < N; i++){
            price[i] = Integer.parseInt(st.nextToken());
            if(i != N - 1 && min > price[i]){
                min = price[i];
                min_index = i;
            }
        }

        int index = 0;
        int total = 0;
        int rest_distance = 0;
        for(int i = 0; i < N - 1; i++){
            if(i < min_index){
                if(price[i] < price[index]) index = i;

                total += (price[index] * distance[i]);
            }
            else{
                rest_distance += distance[i];
            }
        }

        total += (price[min_index] * rest_distance);

        System.out.println(total);
    }
}
