import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] word = bf.readLine().toUpperCase().toCharArray();
        int end = 'Z' - 'A';
        int[] cnt = new int[end + 1];
        int[] max = new int[end + 1];

        for(int i = 0; i < word.length; i++){
            int input = word[i] - 'A';
            cnt[input]++;
            max[input]++;
        }

        Arrays.sort(cnt);

        if(cnt[cnt.length - 1] == cnt[cnt.length - 2]) System.out.println("?");
        else{
            for(int i = 0; i < max.length; i++){
                if(max[i] == cnt[cnt.length - 1]){
                    int result = i + 'A';
                    System.out.println((char)result);
                }
            }
        }
    }
}