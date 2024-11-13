package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 해킹10282 {
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
	
	static int start, comNum, line, com;
	static int[] time;
	static boolean[] visited;
	static ArrayList<Node>[] info;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			comNum = Integer.parseInt(st.nextToken());
			line = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			com = 0;
			
			time = new int[comNum + 1];
			visited = new boolean[comNum + 1];
			info = new ArrayList[comNum + 1];
			Arrays.fill(time, Integer.MAX_VALUE);
			
			for (int i = 0; i < info.length; i++) {
				info[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < line; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				info[b].add(new Node(a, Integer.parseInt(st.nextToken())));
			}
			
			dijkstra();
			int result = 0;
			for (int i = 0; i < time.length; i++) {
				if (time[i] == Integer.MAX_VALUE) continue;
				
				result = Math.max(result, time[i]);
			}
			sb.append(com + " " + result + "\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		time[start] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if (visited[current.next]) continue;
			visited[current.next] = true;
			com++;
			
			for (Node n : info[current.next]) {
				Node migi = new Node(n.next, current.cost + n.cost);
				if (migi.cost < time[migi.next]) {
					time[migi.next] = migi.cost;
					queue.add(migi);
				}
			}
		}
	}

}
