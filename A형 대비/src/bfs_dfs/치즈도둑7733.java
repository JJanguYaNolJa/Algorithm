package bfs_dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class 치즈도둑7733 {
     
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int day;
    static int result;
    static int count;
    static int N;
     
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
         
        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            result = 1;
             
            for (day = 1; day < 100; day++) {
                queue = new LinkedList<int[]>();
                visited = new boolean[N][N];
                count = 0;
                 
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > day && !visited[i][j]) {
                            count++;
                            visited[i][j] = true;
                            queue.add(new int[] {i, j});
                            find();
                        }
                    }
                }
                result = Math.max(result, count);
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
     
    static void find() {
         
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
             
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                 
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] > day) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}