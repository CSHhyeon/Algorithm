import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());   //사람들이 임스와 같이 플레이하기를 신청한 횟수
        String type = st.nextToken();               //같이 플레이할 게임의 종류

        int people = 0;
        if(type.equals("Y")) people = 1;
        else if(type.equals("F")) people = 2;
        else if(type.equals("O")) people = 3;

        HashMap<String, Integer> map = new HashMap<>(); //한 번 같이 플레이한 사람은 참가 불가 - 중복을 거르기 위함
        for(int i = 0; i < N; i++){
            map.put(bf.readLine(), i);
        }

        System.out.println(map.size() / people);
    }
}
