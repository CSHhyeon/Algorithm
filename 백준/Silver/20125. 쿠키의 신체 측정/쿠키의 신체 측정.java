import java.util.*;
import java.io.*;

class Cookie{
	private int x;
	private int y;
	
	public Cookie(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class Main {
	static Cookie legStart = null;
	static char[][] arr;
	static int leftHand(Cookie heart) {
		Queue<Cookie> que = new LinkedList<>();
		que.offer(heart);
		
		int length = 0;
		while(!que.isEmpty()) {
			Cookie hand = que.poll();
			int x = hand.getX();
			int y = hand.getY();
			
			if(y - 1 < 0) break;
			
			if(arr[x][y - 1] == '*') {
				que.offer(new Cookie(x, y - 1));
				length++;
			}
		}
		
		return length;
	}
	
	static int rightHand(Cookie heart) {
		Queue<Cookie> que = new LinkedList<>();
		que.offer(heart);
		
		int length = 0;
		while(!que.isEmpty()) {
			Cookie hand = que.poll();
			int x = hand.getX();
			int y = hand.getY();
			
			if(y + 1 >= arr[0].length) break;
			
			if(arr[x][y + 1] == '*') {
				que.offer(new Cookie(x, y + 1));
				length++;
			}
		}
		
		return length;
	}
	
	static int waist(Cookie heart) {
		Queue<Cookie> que = new LinkedList<>();
		que.offer(heart);
		
		int length = 0;
		while(!que.isEmpty()) {
			Cookie waist = que.poll();
			int x = waist.getX();
			int y = waist.getY();
			
			if(arr[x + 1][y] == '*') {
				legStart = new Cookie(x + 1, y);
				que.offer(legStart);
				length++;
			}
		}
		
		return length;
	}
	
	static int leftLeg() {
		Queue<Cookie> que = new LinkedList<>();
		int waistX = legStart.getX();
		int waistY = legStart.getY();
		que.offer(new Cookie(waistX + 1, waistY - 1));
		
		int length = 1;
		while(!que.isEmpty()) {
			Cookie leg = que.poll();
			int x = leg.getX();
			int y = leg.getY();
			
			if(x + 1 >= arr.length) break;
			
			if(arr[x + 1][y] == '*') {
				que.offer(new Cookie(x + 1, y));
				length++;
			}
		}
		
		return length;
	}
	
	static int rightLeg() {
		Queue<Cookie> que = new LinkedList<>();
		int waistX = legStart.getX();
		int waistY = legStart.getY();
		que.offer(new Cookie(waistX + 1, waistY + 1));
		
		int length = 1;
		while(!que.isEmpty()) {
			Cookie leg = que.poll();
			int x = leg.getX();
			int y = leg.getY();
			
			if(x + 1 >= arr.length) break;
			
			if(arr[x + 1][y] == '*') {
				que.offer(new Cookie(x + 1, y));
				length++;
			}
		}
		
		return length;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		arr = new char[N][N];
		for(int i = 0; i < N; i++) {
			char[] temp = bf.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				arr[i][j] = temp[j];
			}
		}
		
		Cookie heart = null;
		boolean foundHead = false;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == '*') {
					heart = new Cookie(i + 1, j);
					sb.append(i + 2).append(" ").append(j + 1).append('\n');
					foundHead = true;
					break;
				}
			}
			if(foundHead) break;
		}
		
		sb.append(leftHand(heart)).append(" ");		//왼쪽 팔
		sb.append(rightHand(heart)).append(" ");		//오른쪽 팔
		sb.append(waist(heart)).append(" ");		//허리	
		sb.append(leftLeg()).append(" ");		//왼쪽 다리
		sb.append(rightLeg());		//오른쪽 다리
		
		System.out.println(sb);
	}
}
