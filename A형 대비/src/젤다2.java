import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 젤다2 {
	static int[][] map;
	static int[][] money;
	static boolean[][] visited;
	static Queue<int[]> queue;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

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
			queue = new LinkedList<>();
			
			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < t; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			queue.add(new int[] {0, 0});
			find();
			sb.append(money[t - 1][t - 1] + "\n");	
			
			t = Integer.parseInt(in.readLine());
			tc++;
		}
		System.out.println(sb);
	}
	
	static void find() {
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0]; int y = current[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length) {
					if (visited[nx][ny]) {
						if (money[nx][ny] > money[x][y] + map[nx][ny]) {
							money[nx][ny] = money[x][y] + map[nx][ny];
							queue.add(new int[] {nx, ny});
						}
						else {
							return;
						}
					}
					else {
						money[nx][ny] = money[x][y] + map[nx][ny];
						visited[nx][ny] = true;
						queue.add(new int[] {nx, ny});
					}
					
					find();
				}
			}
		}
	}
}
