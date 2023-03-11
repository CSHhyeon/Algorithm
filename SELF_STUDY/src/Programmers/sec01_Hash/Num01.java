package Programmers.sec01_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num01 {
	//해시함수 사용하고 싶은 경우 HashSet을 이용해 중복값 없이 개수를 세면 된다.
	//HashSet보다 HashMap이 빠르니 HashMap의 사용을 권장한다고 한다.
	public static int solution2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
        	map.put(nums[i], i);
        }
        //값이 중복되어 들어가지 않기 때문에 map의 사이즈만큼의 개수를 세면 된다.
        return map.size() > nums.length / 2 ? nums.length / 2 : map.size();
    }
	
	public static int solution(int[] nums) {
        int answer = 1;
        Arrays.sort(nums);
        //N/2마리의 포켓몬을 선택. 단, 서로 다른 종류이어야 함
        for(int i = 0; i < nums.length; i++) {
        	if(i != 0 && nums[i] != nums[i - 1]) answer++;
        	if(answer == nums.length / 2) return answer;
        }
        return answer;
    }
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());	//포켓몬의 수 : 짝수
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(nums));
	}
}
