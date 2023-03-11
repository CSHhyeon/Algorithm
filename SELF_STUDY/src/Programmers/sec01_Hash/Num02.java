package Programmers.sec01_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//해시 안에 있는 문제니 해시함수를 사용해보자.. HashMap, HashSet, ....
//String일 때에는 일단 HashMap을 떠올려보기!
public class Num02 {
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        //participant를 키로 받고, 값들은 1로 하자. 중복인 경우 중복인 만큼 값을 올리자
        for(int i = 0; i < participant.length; i++) {
        	if(!map.containsKey(participant[i])) {
        		map.put(participant[i], 1);
        	}
        	else {	//키가 있다면 값 하나 증가시켜서 넣기
        		int num = map.get(participant[i]);
        		map.put(participant[i], ++num);
        	}
        }
        
        //completion으로 키의 유무를 확인하고 값이 1이면 out시키고, 값이 2 이상이면 값만 줄이자
        for(int i = 0; i < completion.length; i++) {
        	if(map.get(completion[i]) == 1) {
        		map.remove(completion[i]);
        	}
        	else {
        		int num = map.get(completion[i]);
        		map.put(completion[i], --num);
        	}
        }
        
        //이제 participant에 남은 인원은 한 명일 것
        for(String key : map.keySet()) {
        	answer = key;
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] participant = new String[N];
		String[] completion = new String[N - 1];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			participant[i] = st.nextToken();
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N - 1; i++) {
			completion[i] = st.nextToken();
		}
		
		System.out.println(solution(participant, completion));
	}
}

//1.참여자, 완주자 모두 오름차순으로 정렬
//2.완주자라는 리스트에서 참여자와 비슷하면 넘어가고 일치하지 않는 순간, 바로 return
//3.만약에 다 완주하면 참여자 맨 마지막 부분 return