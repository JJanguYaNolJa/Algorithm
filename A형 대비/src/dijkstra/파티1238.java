package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티1238 {
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
	
	static int student, line, party;
	static boolean[] galvisited, olvisited;
	static int[] galddae, olddae;
	static ArrayList<Node>[] gal, ol;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		student = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		party = Integer.parseInt(st.nextToken());
		
		galvisited = new boolean[student + 1];
		olvisited = new boolean[student + 1];
		galddae = new int[student + 1];
		olddae = new int[student + 1];
		
		gal = new ArrayList[student + 1];
		ol = new ArrayList[student + 1];
		
		for (int i = 0; i < gal.length; i++) {
			gal[i] = new ArrayList<>();
			ol[i] = new ArrayList<>();
		}
		
		Arrays.fill(galddae, Integer.MAX_VALUE);
		Arrays.fill(olddae, Integer.MAX_VALUE);
		
		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			ol[a].add(new Node(b, c));
			gal[b].add(new Node(a, c));
		}
		
		galDijkstra();
		olDijkstra();
		
		int result = 0;
		for (int i = 0; i < gal.length; i++) {
			int sum = galddae[i] + olddae[i];
			result = Math.max(result, sum);
		}
		System.out.println(result);
	}
	
	static void galDijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(party, 0));
		galddae[party] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if (galvisited[current.next]) continue;
			galvisited[current.next] = true;
			
			for (Node n : gal[current.next]) {
				Node migi = new Node(n.next, n.cost + current.cost);
				
				if (migi.cost < galddae[migi.next]) {
					galddae[migi.next] = migi.cost;
					queue.add(migi);
				}
			}
		}
	}
	
	static void olDijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(party, 0));
		olddae[party] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if (olvisited[current.next]) continue;
			olvisited[current.next] = true;
			
			for (Node n : ol[current.next]) {
				Node migi = new Node(n.next, n.cost + current.cost);
				
				if (migi.cost < olddae[migi.next]) {
					olddae[migi.next] = migi.cost;
					queue.add(migi);
				}
			}
		}
	}

}
