import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   //영어 지문에 나오는 단어의 개수
        int M = Integer.parseInt(st.nextToken());   //외울 단어의 길이 기준이 되는 M

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String input = bf.readLine();
            if(input.length() >= M){
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }

        PriorityQueue<String> que = new PriorityQueue<>((o1, o2) -> {
            if(map.get(o1) == map.get(o2)){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);    //잘 기억해두자
                }
                else{
                    return o2.length() - o1.length();
                }
            }
            else return map.get(o2) - map.get(o1);
        });

        for(String key : map.keySet()){
            que.offer(key);
        }

        while(!que.isEmpty()){
            sb.append(que.poll());
            if(que.size() != 0) sb.append('\n');
        }

        System.out.println(sb);
    }
}
