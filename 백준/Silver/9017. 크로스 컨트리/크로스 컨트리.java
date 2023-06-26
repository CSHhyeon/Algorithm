import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());    //테스트 케이스의 수
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(bf.readLine());
            HashMap<Integer, Integer> teamMember = new HashMap<>();   //팀 멤버 수가 6명이 맞는지 확인
            st = new StringTokenizer(bf.readLine(), " ");
            int[] team = new int[N];
            for(int j = 0; j < N; j++){
                team[j] = Integer.parseInt(st.nextToken());
                teamMember.put(team[j], teamMember.getOrDefault(team[j], 0) + 1);
            }

            HashMap<Integer, Integer> teamScore = new HashMap<>();
            int[] number = new int[teamMember.size() + 1];
            int[] fifth = new int[teamMember.size() + 1];
            int rank = 0;
            for(int j = 0; j < N; j++){
                if(teamMember.get(team[j]) == 6){
                    rank++;
                    number[team[j]]++;
                    if(number[team[j]] <= 4) teamScore.put(team[j], teamScore.getOrDefault(team[j], 0) + rank);
                    else if(number[team[j]] == 5) fifth[team[j]] = rank;
                }
            }

            int winner = 0;
            int score = Integer.MAX_VALUE;
            for(int key : teamScore.keySet()){
                if(score > teamScore.get(key)){
                    score = teamScore.get(key);
                    winner = key;
                }
                else if(score == teamScore.get(key)){
                    if(fifth[winner] > fifth[key]){
                        score = teamScore.get(key);
                        winner = key;
                    }
                }
            }

            System.out.println(winner);
        }
    }
}
