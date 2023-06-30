import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] num = bf.readLine().toCharArray();

        int N = 1;
        boolean out = false;
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        for(int i = 0; i < num.length; i++){
            out = false;

            while(!out){
                if(que.size() == 0){
                    N++;
                    if(N >= 10){
                        char[] n = Integer.toString(N).toCharArray();
                        for(int j = 0; j < n.length; j++){
                            que.offer(n[j] - '0');
                        }
                    }
                    else que.offer(N);
                }
                else{
                    if(que.poll() == num[i] - '0') out = true;
                }
            }
        }

        System.out.println(N);
    }
}
