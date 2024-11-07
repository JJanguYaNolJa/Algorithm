package bfs_dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class 미로1226 {
     
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> queue;
    static int result;
    static int dochakX, dochakY;
 
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < 10; tc++) {
            int t = Integer.parseInt(in.readLine());
            sb.append("#" + t + " ");
            map = new int[16][16];
            visited = new boolean[16][16];
            result = 0;
            queue = new LinkedList<int[]>();
             
            for (int i = 0; i < 16; i++) {
                String[] line = in.readLine().split("");
                for (int j = 0; j < 16; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                    if (map[i][j] == 2) {
                        queue.add(new int[] {i, j});
                    }
                     
                    else if (map[i][j] == 3) {
                        dochakX = i; dochakY = j;
                    }
                }
            }
 
            find();
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
     
    private static void find() {
         
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
             
            if (x == dochakX && y == dochakY) {
                result = 1;
                return;
            }
             
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                 
                if (nx >= 0 && ny >= 0 && nx < 16 && ny < 16 && !visited[nx][ny] && map[nx][ny] != 1) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}