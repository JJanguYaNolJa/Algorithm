import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물놀이를가자10966 {
	
	static int N;
	static int M;
	static String[][] map;
	static boolean[][] visited;
	static int[][] dis;
	static Queue<int[]> queue;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new String[N][M];
			visited = new boolean[N][M];
			dis = new int[N][M];
			queue = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				String[] line = in.readLine().split("");
				for (int j = 0; j < M; j++) {
					map[i][j] = line[j];
					if (map[i][j].equals("W")) {
						queue.add(new int[] {i, j});
						visited[i][j] = true;
					}
				}
			}
			
			int result = 0;
			
			while(!queue.isEmpty()) {
				int[] current = queue.poll();
				int x = current[0];
				int y = current[1];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
						dis[nx][ny] = dis[x][y] + 1;
						queue.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						result += dis[nx][ny];
					}
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
