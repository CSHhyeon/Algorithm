import java.util.*;
import java.io.*;

public class Main {
    public static boolean isVowel(char pwd){
        if(pwd == 'a' || pwd == 'e' || pwd == 'i' || pwd == 'o' || pwd == 'u') return true;
        else return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String pwd = bf.readLine();
        boolean vowel = false;
        boolean continuous = false;
        boolean same = false;
        while(!pwd.equals("end")){
            vowel = false;
            continuous = false;
            same = false;

            char[] arr = pwd.toCharArray();
            int isVowel = 0;
            int notVowel = 0;
            if(isVowel(arr[0])) isVowel++;
            else notVowel++;
            for(int i = 0; i < arr.length; i++){
                if(isVowel(arr[i])) vowel = true;
                if(i != 0){
                    if(arr[i - 1] == arr[i] && arr[i] != 'e' && arr[i] != 'o'){
                        same = true;
                        break;
                    }

                    if(isVowel(arr[i])){
                        isVowel++;
                        if(!isVowel(arr[i - 1])) notVowel = 0;
                    }
                    else{
                        notVowel++;
                        if(isVowel(arr[i - 1])) isVowel = 0;
                    }

                    if(isVowel == 3 || notVowel == 3){
                        continuous = true;
                        break;
                    }
                }
            }

            if(vowel && !continuous && !same) System.out.println("<" + pwd + "> is acceptable.");
            else System.out.println("<" + pwd + "> is not acceptable.");

            pwd = bf.readLine();
        }

    }
}
