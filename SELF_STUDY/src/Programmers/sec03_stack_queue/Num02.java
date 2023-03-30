import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //1단계) 각 작업이 완료되는데 걸리는 날짜를 배열에
        int[] day = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            int cnt = 0;
            int percent = progresses[i];
            while(percent < 100){
                percent += speeds[i];
                cnt++;
            }
            day[i] = cnt;
        }
        
        //2단계) 뒤에값이 앞에 값보다 커질때까지 cnt++하고
        //만약 뒤에값이 더 큰 값이 나오면 그 때 출력해 cnt값을 큐에 넣기
        Queue<Integer> que = new LinkedList<>();
        int cnt = 1;
        int first = day[0];
        for(int i = 1; i < day.length; i++){
            if(i == day.length - 1){
                if(first < day[i]){
                    que.offer(cnt);
                    que.offer(1);
                }
                else{
                    que.offer(++cnt);   
                }
            }
            else{
                if(first < day[i]){
                que.offer(cnt);
                cnt = 1;
                first = day[i];
                }
                else{
                    cnt++;
                }
            }
        }
        
        int[] answer = new int[que.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = que.poll();
        }
        return answer;
    }
}
