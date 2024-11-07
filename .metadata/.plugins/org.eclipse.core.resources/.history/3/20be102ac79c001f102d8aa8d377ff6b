import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 방향전환8382 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			int xChai = Math.abs(startX - endX);
			int yChai = Math.abs(startY - endY);
			
			int minChai = Math.min(xChai, yChai);
			int namuji = Math.max(xChai, yChai) - minChai;
			int result = minChai * 2;
			
			if (namuji % 2 == 0) {
				result += namuji * 2;
			}
			else if (namuji % 2 != 0) {
				result += (namuji - 1) * 2 + 1;
			}
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}
}
