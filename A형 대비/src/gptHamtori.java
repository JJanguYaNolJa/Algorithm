import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gptHamtori {
    static int woori, limit, tc;
    static int[][] line;
    static int[] result, bestResult;
    static int maxHamtori;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            woori = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            tc = Integer.parseInt(st.nextToken());

            result = new int[woori];
            bestResult = new int[woori];
            line = new int[tc][3];
            maxHamtori = -1;

            for (int i = 0; i < tc; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                line[i][0] = Integer.parseInt(st.nextToken()) - 1;
                line[i][1] = Integer.parseInt(st.nextToken()) - 1;
                line[i][2] = Integer.parseInt(st.nextToken());
            }

            // 백트래킹을 통해 햄스터 배치 탐색
            backtrack(0, 0);

            if (maxHamtori == -1) {
                sb.append(-1 + "\n");
            } else {
                for (int i = 0; i < woori; i++) {
                    sb.append(bestResult[i] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void backtrack(int index, int hamtoriCount) {
        if (index == woori) { // 모든 칸에 대한 배치를 마쳤을 때
            if (checkRecords()) { // 기록 조건을 만족하는지 확인
                if (hamtoriCount > maxHamtori || (hamtoriCount == maxHamtori && isLexicographicallySmaller())) {
                    maxHamtori = hamtoriCount;
                    System.arraycopy(result, 0, bestResult, 0, woori);
                }
            }
            return;
        }

        for (int i = 0; i <= limit; i++) { // 0 ~ limit 마리까지 배치 시도
            result[index] = i;
            backtrack(index + 1, hamtoriCount + i);
        }
    }

    static boolean checkRecords() {
        for (int[] record : line) {
            int start = record[0], end = record[1], sum = record[2];
            int count = 0;
            for (int i = start; i <= end; i++) {
                count += result[i];
            }
            if (count != sum) return false; // 기록을 만족하지 않으면 false 반환
        }
        return true;
    }

    // 사전순으로 더 작은지 확인하는 함수
    static boolean isLexicographicallySmaller() {
        for (int i = 0; i < woori; i++) {
            if (result[i] < bestResult[i]) return true;
            if (result[i] > bestResult[i]) return false;
        }
        return false;
    }
}
