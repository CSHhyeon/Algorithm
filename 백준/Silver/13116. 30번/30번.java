import java.util.*;
import java.io.*;

class Tree{
	private int me;
	private int parent;
	private int depth;
	
	public Tree(int me, int parent, int depth) {
		this.me = me;
		this.parent = parent;
		this.depth = depth;
	}
	
	public int getMe() {
		return this.me;
	}
	
	public int getParent() {
		return this.parent;
	}
	
	public int getDepth() {
		return this.depth;
	}
}

public class Main {

	public static void main(String[] args) throws IOException{
		int depth = 1;
		Tree[] tree = new Tree[1024];
		tree[1] = new Tree(1, 1, depth);
		for(int i = 2; i <= 1023; i++) {
			if(i == (int)Math.pow(2, depth)) depth++;
			tree[i] = new Tree(i, tree[i / 2].getMe(), depth);
		}
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());	//테스트 케이스의 수
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int k = tree(tree, A, B);
			System.out.println(k * 10);
		}

	}
	
	public static int tree(Tree[] tree, int A, int B) {
		Tree one = tree[A];
		Tree two = tree[B];
		
		while(one.getMe() != two.getMe()) {
			while(one.getDepth() != two.getDepth()) {
				int oneDepth = one.getDepth();
				int twoDepth = two.getDepth();
				
				if(oneDepth < twoDepth) two = tree[two.getParent()];
				else one = tree[one.getParent()];
			}
			
			if(one.getMe() != two.getMe()) {
				one = tree[one.getParent()];
				two = tree[two.getParent()];
			}
		}
		
		return one.getMe();
	}

}
