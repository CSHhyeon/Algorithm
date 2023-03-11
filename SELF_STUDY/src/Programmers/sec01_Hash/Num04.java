package Programmers.sec01_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Num04 {	
	//getOrDefault(Object key, V DefaultValue)
	//key : 값을 가져와야 하는 요소의 키, defaultValue : 지정된 키로 매핑된 값이 없는 경우 반환되어야 하는 기본값
	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();	//종류별 개수를 구해 수학 계산하면 되지 않을까
        for(int i = 0; i < clothes.length; i++) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(String key : map.keySet()) {
        	answer *= (map.get(key) + 1);
        }
        return answer - 1;
    }
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[][] clothes = new String[N][N];
		for(int i = 0; i < N; i++) {
			String input = bf.readLine();
			clothes[i][0] = input.split(" ")[0];	//이름 : yellow_hat, green_turban
			clothes[i][1] = input.split(" ")[1];	//종류 : headgear, eyewear
		}
		
		System.out.println(solution(clothes));
	}
}

/*
 만약 안경 : 1, 모자 : 2, 마스크 : 3이라면
 각자 하나씩 쓰는 경우 1 + 2 + 3 = 6
 2개 골라서 쓰는 경우 (안경, 모자) : 1 * 2 = 2, (안경, 마스크) : 1 * 3 = 3, (모자, 마스크) : 2 * 3 = 6
 3개 골라서 쓰는 경우 : 1 * 2 * 3
 -----------------------------------------------------------------------
 만약 안경 : 1, 모자 : 2, 마스크 : 3, 양말 : 4라면
 각자 하나씩 쓰는 경우 : 1 + 2 + 3 + 4 = 10
 2개 골라서 쓰는 경우 : 1*2 + 1*3 + 1*4 + 2*3 + 2*4 + 3*4 =35
 3개 골라서 쓰는 경우 : 1*2*3 + 1*2*4 + 1*3*4 + 2*3*4 = 50
 4개 골라서 쓰는 경우 : 1*2*3*4 = 24
 최종 -> 10 + 35 + 50 + 24 = 119
 -----------------------------------------------------------------------
 처음에 풀었던게 틀렸다고 나왔기도 하고 전혀 다른 방식 같아서 다른 방법으로 접근
 안경, 모자, 마스크, 양말이 있을 때 최소 1개씩은 입는다.
 그렇다면 안쓰는 경우의 수를 추가한 뒤 아예 안 입었을 하나를 빼면 값이 같을까?
(1 + 1) * (2 * 1) + (3 * 1) * (4 * 1) = 120 -> 이 때 각각 +1 하는 것은 안 입었을 경우를 추가한 것
아예 안 입을 수는 없으니 최종값에서 -1하면 120 - 1 = 119로 값 똑같게 나온다.
이렇게 쉽게 나오는거 왜 그리 고생을 했는고..
 */
