import java.util.*;
import java.io.*;

class Node{
	private int node;
	private int weight;
	
	public Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
	
	public int getNode() {
		return this.node;
	}
	
	public int getWeight() {
		return this.weight;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> list;
	static int[] graph;
	static int INF = Integer.MAX_VALUE;
	
	public static void bfs(int start) {
		PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> {
			return o1.getWeight() - o2.getWeight();
		});
		
		que.offer(new Node(start, 0));
		
		while(!que.isEmpty()) {
			Node s = que.poll();
			int curNode = s.getNode();
			
			for(int i = 0; i < list.get(curNode).size(); i++) {
				Node input = list.get(curNode).get(i);
				
				int node = input.getNode();
				int weight = input.getWeight();
				
				if(graph[node] > graph[curNode] + weight) {
					graph[node] = graph[curNode] + weight;
					que.offer(new Node(node, graph[node]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());	//정점의 개수
		int E = Integer.parseInt(st.nextToken());	//간선의 개수

		int start = Integer.parseInt(bf.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= V; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());	
			int w = Integer.parseInt(st.nextToken());	//weight
			
			list.get(u).add(new Node(v, w));
		}
		
		graph = new int[V + 1];
		for(int i = 0; i < graph.length; i++) {
			graph[i] = INF;
		}
		
		graph[start] = 0;
		bfs(start);
		
		for(int i = 1; i <= V; i++) {
			if(graph[i] == INF) sb.append("INF");
			else sb.append(graph[i]);
			
			if(i != V) sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
