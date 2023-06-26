import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());    //스위치의 개수
        st = new StringTokenizer(bf.readLine(), " ");
        int[] state = new int[N + 1];                   //각 스위치의 상태 - 1 : ON, 0 : OFF
        for(int i = 1; i <= N; i++){
            state[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());    //학생의 수
        int[][] student = new int[M][2];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            student[i][0] = Integer.parseInt(st.nextToken());   //학생의 성별 - 1 : 남학생, 2 : 여학생
            student[i][1] = Integer.parseInt(st.nextToken());   //학생이 받은 수
        }

        for(int i = 0; i < M; i++){
            int num = student[i][1];
            if(student[i][0] == 1){     //남학생 - 자신이 받은 배수들 상태 스위치 change
                int multi = 1;
                while(multi * num <= N){
                    int index = num * multi++;
                    state[index] = (state[index] + 1) % 2;
                }
            }
            else{      //여학생 - 자신을 중심으로 좌우 대칭 아닌 곳까지 change
                int add = 0;
                while(state[num - add] == state[num + add]){
                    if(add == 0) state[num] = (state[num] + 1) % 2;
                    else{
                        state[num - add] = (state[num - add] + 1) % 2;
                        state[num + add] = (state[num + add] + 1) % 2;
                    }

                    add++;
                    if(num - add < 1 || num + add > N) break;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            sb.append(state[i]);
            if(i != N) sb.append(" ");
            if(i % 20 == 0) sb.append('\n');
        }

        System.out.println(sb);
    }
}
