package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로1753 {
	static class Node implements Comparable<Node> {
		int next, cost;

		public Node(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int V, E, start;
	static ArrayList<Node>[] info;
	static int[] dis;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(in.readLine());
		dis = new int[V + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		visited = new boolean[V + 1];
		info = new ArrayList[V + 1];
		for (int i = 0; i < info.length; i++) {
			info[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			info[index].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		dijkstra();
		for (int i = 1; i < dis.length; i++) {
			if (dis[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(dis[i]);
			}
		}
	}
	
	static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		dis[start] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if (visited[current.next]) continue;
			visited[current.next] = true;
			
			for (Node n : info[current.next]) {
				Node migi = new Node(n.next, current.cost + n.cost);
				if (migi.cost < dis[migi.next]) {
					dis[migi.next] = migi.cost;
					queue.add(migi);
				}
			}
		}
	}

}
