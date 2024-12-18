package queue;
import java.io.*;
import java.util.*;

public class 암호생성기1225 {
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			queue = new LinkedList<>();
			
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int minus = 1;
			
			while(true) {
				int amHo = queue.poll();
				amHo -= minus;
				
				if (amHo <= 0) {
					queue.add(0);
					break;
				}
				
				queue.add(amHo);
				minus++;
				
				if (minus > 5) {
					minus = 1;
				}
			}
			
			while(!queue.isEmpty()) {
				sb.append(queue.poll() + " ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
