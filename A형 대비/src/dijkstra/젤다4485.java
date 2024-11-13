package dijkstra;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 젤다4485 {
	
	static class Node implements Comparable<Node> {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	static int[][] map;
	static int[][] money;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static ArrayList<Node>[] info;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		int tc = 1;
		while(t != 0) {
			sb.append("Problem " + tc + ": ");
			map = new int[t][t];
			money = new int[t][t];
			visited = new boolean[t][t];
			info = new ArrayList[t];
			
			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < t; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < info.length; i++) {
				info[i] = new ArrayList<>();
				Arrays.fill(money[i], Integer.MAX_VALUE);
			}
			
			dijkstra();
			
			sb.append(money[t - 1][t - 1] + "\n");
			
			t = Integer.parseInt(in.readLine());
			tc++;
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(0, 0, map[0][0]));
		money[0][0] = map[0][0];
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if (visited[current.x][current.y]) continue;
			visited[current.x][current.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length) {
					int nc = current.cost + map[nx][ny];
					if (nc < money[nx][ny])
					money[nx][ny] = nc;
					queue.add(new Node(nx, ny, nc));
				}
			}
		}
	}
}
