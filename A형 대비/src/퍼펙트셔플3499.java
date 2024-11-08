import java.io.*;
import java.util.*;

public class 퍼펙트셔플3499 {
	
	static Queue<String> queue1;
	static Queue<String> queue2;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t);
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			for (int i = 1; i <= N/2; i++) {
				queue1.add(st.nextToken());
			}
			
			if (N % 2 == 1) {
				queue1.add(st.nextToken());
			}
			
			for (int i = (N/2 + 1); i <= N; i++) {
				queue2.add(st.nextToken());
			}
			
			for (int i = 0; i < N/2; i++) {
				sb.append(" " + queue1.poll() + " " + queue2.poll());
			}
			
			if (!queue1.isEmpty()) {
				sb.append(" " + queue1.poll());
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
