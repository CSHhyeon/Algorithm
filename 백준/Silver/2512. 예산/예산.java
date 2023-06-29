import java.util.*;
import java.io.*;

public class Main {
    static int[] budget;
    public static int find(int total){
        int end = budget[budget.length - 1];
        int start = 0;
        int result = 0;
        int upper = 0;

        while(start <= end){
            int sum = 0;
            int mid = (start + end) / 2;

            for(int i = 0; i < budget.length; i++){
                if(mid >= budget[i]) sum += budget[i];
                else sum += mid;
            }

            if(sum <= total){
                if(result < sum) {
                    result = sum;
                    upper = mid;
                }
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return upper;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());    //지방의 수

        st = new StringTokenizer(bf.readLine(), " ");
        budget = new int[N];
        for(int i = 0; i < N; i++){
            budget[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(budget);
        int total = Integer.parseInt(bf.readLine());

        System.out.println(find(total));
    }
}
