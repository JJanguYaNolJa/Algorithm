import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 햄토리8275 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int woori = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			int tc = Integer.parseInt(st.nextToken());

			int[][] line = new int[tc][3];
			int[] result = new int[woori];
			boolean possible = true;

			for (int i = 0; i < tc; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				line[i][0] = Integer.parseInt(st.nextToken());
				line[i][1] = Integer.parseInt(st.nextToken());
				line[i][2] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(line, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o2[1] - o1[1];
				}
			});

			for (int i = 0; i < line.length; i++) {
				int start = line[i][0] - 1;
				int end = line[i][1] - 1;
				int value = line[i][2];

				boolean migi = (i > 0 && start >= line[i - 1][0] - 1);
				
				for (int j = end; j >= start && value > 0; j--) {
					if (i > 0 && j >= line[i - 1][0] - 1 && j <= line[i - 1][1] - 1) {
						if (migi) {
							int preValue = line[i - 1][2] - value;
							
							for (int k = end + 1; k <= line[i - 1][1] - 1; k++) {
								int minus = Math.min(preValue, result[k]);
								result[k] = minus;
								preValue -= minus;
							}
						} 
						else {
							value -= result[j];
							continue;
						}
					}

					int add = Math.min(limit - result[j], value);
					result[j] += add;
					value -= add;
				}

				if (value != 0) {
					migi = (i > 0 && end >= line[i - 1][0] - 1 && end <= line[i - 1][1] - 1);
					if (migi) {
						int add = Math.min(limit, value);
						result[start] = add;
						value -= add;
						
						for (int j = end; j > start; j++) {
							
						}
					}
					
					else {
						possible = false;
						sb.append(-1 + "\n");
						break;
					}
				}
			}

			if (possible) {
				int end = line[0][1] - 1;

				for (int i = 0; i < result.length; i++) {
					if (i > end) {
						result[i] = limit;
					}
					sb.append(result[i] + " ");
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}
