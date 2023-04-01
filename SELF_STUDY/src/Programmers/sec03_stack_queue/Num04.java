import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        //location, priorities를 키-값으로 가지는 map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < priorities.length; i++){
            map.put(i, priorities[i]);
        }
        
        //우선순위를 내림차순으로 받은 prior 큐
        Queue<Integer> prior = new LinkedList<>();
        int[] sorted = priorities.clone();
        Arrays.sort(sorted);
        for(int i = 0; i < sorted.length; i++){
            prior.offer(sorted[sorted.length - 1 - i]);
        }
        
        //이제부터 계산을 시작할 que
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            que.offer(i);
        }
        
        int answer = 0;
        int out = -1;
        while(true){
            if(map.get(que.peek()) != prior.peek()){
                que.offer(que.poll());
            }
            else{
                out = que.poll();
                prior.poll();
                answer++;
                
                if(location == out) break;
            }
        }
        
        return answer;
    }
}
