import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int P = Integer.parseInt(bf.readLine());    //테스트케이스의 수
        for(int i = 0; i < P; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());   //테스트케이스 번호
            int A = Integer.parseInt(st.nextToken());   //기준 학생
            int cnt = 0;    //뒤로 물러선 수
            ArrayList<Integer> line = new ArrayList<>();
            line.add(A);
            for(int j = 0; j < 19; j++){
                Collections.sort(line);
                int size = line.size();

                int student = Integer.parseInt(st.nextToken());
                if(line.get(size - 1) > student){
                    for(int k = 0; k < size; k++){
                        if(line.get(k) > student){
                            cnt += (size - k);
                            break;
                        }
                    }
                }
                line.add(student);
            }
            sb.append(T).append(" ").append(cnt);
            if(i != P - 1) sb.append('\n');
        }
        System.out.println(sb);
    }
}
