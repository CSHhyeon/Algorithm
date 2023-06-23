import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());    //전체 사람의 수

        // 0 : 몸무게, 1 : 키, 2 : 인덱스, 3 : 등수
        int[][] person = new int[N][4];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            person[i][0] = Integer.parseInt(st.nextToken());    //몸무게
            person[i][1] = Integer.parseInt(st.nextToken());    //키
            person[i][2] = i;
        }

        Arrays.sort(person, (o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            else return o2[0] - o1[0];
        });

        int k = 0;
        person[0][3] = 1;
        for(int i = 1; i < N; i++){
            k = 0;
            for(int j = 0; j < i; j++){
                if(person[j][0] > person[i][0] && person[j][1] > person[i][1]) k++;
            }

            person[i][3] = k + 1;
        }

        Arrays.sort(person, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        for(int i = 0; i < N; i++){
            sb.append(person[i][3]);
            if(i != N - 1) sb.append(" ");
        }

        System.out.println(sb);
    }
}
