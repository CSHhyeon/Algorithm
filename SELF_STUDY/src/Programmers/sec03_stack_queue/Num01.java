import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(arr[0]);
        //앞 인덱스와 같이 다르면 그 때 큐에 값 넣기
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i - 1]){
                que.offer(arr[i]);
            }
        }
        int[] answer = new int[que.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = que.poll();
        }
        return answer;
    }
}
