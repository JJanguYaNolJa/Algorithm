import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 요리사 {

	static int N;
	static int[][] matTable;
	static int mat1, mat2, matChai;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			N = Integer.parseInt(in.readLine());
			matTable = new int[N][N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					matTable[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			matChai = Integer.MAX_VALUE;
			Comb(0, 0);
			sb.append(matChai + "\n");
		}
		System.out.println(sb);
	}

	static void Comb(int start, int cnt) {
		if (cnt == N/2) {
			mat1 = 0; mat2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i] && visited[j]) {
						mat1 += matTable[i][j];
					}
					else if (!visited[i] && !visited[j]) {
						mat2 += matTable[i][j];
					}
				}
			}

			matChai = Math.min(matChai, Math.abs(mat1 - mat2));
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				Comb(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
