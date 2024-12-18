import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class 최장경로2814 {
	
	static int result;
	static int count;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		map = new HashMap<>(); 
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			result = 1;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 1; i <= M; i++) {
				if (map.containsKey(i)) {
					count = 1;
					find(i);
					result = Math.max(count, result);
				}
			}
			
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
	
	static void find(int i) {
		if (map.containsKey(i)) {
			count++;
			find(map.remove(i));
		}
		else if (map.containsValue(i)) {
			int migi = 0;
			for (Integer key : map.keySet()) {
				if (map.get(key) == i) {
					migi = key;
				}
			}
			find(migi);
		}
	}
}
