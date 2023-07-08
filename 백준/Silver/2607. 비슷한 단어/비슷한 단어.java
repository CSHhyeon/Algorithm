import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] word_num = new int[26];
        char[] word = bf.readLine().toCharArray();
        for(int i = 0; i < word.length; i++){
            word_num[word[i] - 'A']++;
        }

        int result = 0;
        for(int i = 0; i < N - 1; i++){
            int similar = 0;
            char[] compare = bf.readLine().toCharArray();

            if(Math.abs(word.length - compare.length) > 1) continue;

            int[] num = word_num.clone();
            for(int j = 0; j < compare.length; j++){
                num[compare[j] - 'A']--;
            }

            for(int j = 0; j < 26; j++){
                if(num[j] != 0) similar += Math.abs(num[j]);
            }

            if(similar <= 2) result++;
        }

        System.out.println(result);
    }
}
