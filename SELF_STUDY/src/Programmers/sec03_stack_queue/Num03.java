import java.util.*;
class Solution {
    boolean solution(String s) {
        Queue<Character> que = new LinkedList<>();
		boolean answer = true;
		
        //(가 나왔다면 다음으로는 반드시 )로 닫혀야 한다. ((()))
		//( 들어오면 큐에 집어넣기. )가 들어온다면 큐에서 값을 빼서 (가 있는지 확인. 만약 empty면 false
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == ')') {
        		if(que.isEmpty()) return false;
        		else {
        			que.poll();
        		}
        	}
        	if(arr[i] == '(') {
        		if(i == arr.length - 1) return false;
        		else que.offer('(');
        	}
        }

        return que.isEmpty();
    } 
}
