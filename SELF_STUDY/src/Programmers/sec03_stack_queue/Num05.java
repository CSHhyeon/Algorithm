import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //다리 상황
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            que.offer(0);
        }
        
        int answer = 0;
        int index = 0;
        int sum = 0;
        while(index < truck_weights.length){
            sum -= que.poll();    
            answer++;
            
            //다리 위 무게가 다 찼을 때
            if(sum + truck_weights[index] > weight){
                que.offer(0);
            }   
            else{   //다리 위 무게가 차지 않았을 때
                sum += truck_weights[index];
                que.offer(truck_weights[index++]); 
            }
        }
        
        return answer  + bridge_length;
    }
}
