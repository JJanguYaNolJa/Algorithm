package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용1916 {
	
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
	
	static int city, bus, start, end;
	static boolean[] visited;
	static int[] money;
	static ArrayList<Node>[] info;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		city = Integer.parseInt(in.readLine());
		bus = Integer.parseInt(in.readLine());
		
		visited = new boolean[city + 1];
		money = new int[city + 1];
		info = new ArrayList[city + 1];
		
		Arrays.fill(money, Integer.MAX_VALUE);
		for (int i = 0; i < info.length; i++) {
			info[i] = new ArrayList<>();
  		}
		
		for (int i = 0; i < bus; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			info[index].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra();
		System.out.println(money[end]);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		money[start] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if (visited[current.next]) continue;
			visited[current.next] = true;
			
			for (Node n : info[current.next]) {
				Node migi = new Node(n.next, n.cost + current.cost);
				if (migi.cost < money[migi.next]) {
					money[migi.next] = migi.cost;
					queue.add(migi);
				}
			}
		}
	}
}
