package Programmers.sec01_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Num05
{
	public static int[] solution(String[] genres, int[] plays) {
		//1단계) 어떤 장르를 어떤 순서로 많이 들었는지 구해내기
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        //2단계) 장르별 내림차순
        List<String> genre_rank = new ArrayList<>();
        for(String key : map.keySet()){
            genre_rank.add(key);
        }
        Collections.sort(genre_rank, (o1, o2) -> map.get(o2) - map.get(o1));
        
        //3단계) 장르별로 가장 큰 값, 두번째로 큰 값 뽑아내기 +) index에 넣기
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < genre_rank.size(); i++){
            int max = 0;
            int max2 = 0;
            int first = 0;
            int second = -1;
            
            //가장 큰 값 뽑기
            for(int j = 0; j < genres.length; j++){
                if(genre_rank.get(i).equals(genres[j]) && max < plays[j]){
                	max = plays[j];
                    first = j;
                }
            }
            
            //두번째로 큰 값 뽑기
            for(int j = 0; j < genres.length; j++){
                if(genre_rank.get(i).equals(genres[j]) && max2 < plays[j] && j != first){
                	max2 = plays[j];
                    second = j;
                }
            }
            
            
            //TOP2가 2개 있다면
            if(second != -1){
            	if(max == max2) {
            		if(first < second) {
            			list.add(first);
                        list.add(second);
            		}
            		else {
            			list.add(second);
                        list.add(first);
            		}
            	}
            	else {
            		list.add(first);
                    list.add(second);
            	}
            }
            else{   //장르에 값이 하나만 있을 경우
                list.add(first);
            } 
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for(int out : list){
            answer[index++] = out;
        }
        return answer;
    }
	
	public static void main(String[] args)throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());	//배열의 길이
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String[] genres = new String[N];	//고유번호가 i인 노래의 장르
		for(int i = 0; i < N; i++) {
			genres[i] = st.nextToken();
		}
		
		st = new StringTokenizer(bf.readLine());
		int[] plays = new int[N];			//고유번호가 i인 노래가 재생된 횟수
		for(int i = 0; i < N; i++) {
			plays[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = solution(genres, plays);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
/*
속한 노래가 많이 재생된 장르를 먼저 수록
장르 내에서 많이 재생된 노래를 먼저 수록
즉, 일단 장르를 HashMap으로 받아 value가 더 큰 값이 무엇인지 알 수 있다.
배열에 더 많이 재생된 장르의 순서대로 넣는다.

다음으로 예제를 보면 pop 이후에 classic인데 
입력된 것에서 장르가 pop인 아이들의 값들을 받고 최고로 많이 재생된 두 개를 순서대로 answer에 넣는다. 

*/