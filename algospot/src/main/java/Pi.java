import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pi {

    private static String N;
    private static int[] cache = new int[10002];
    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < testCnt; t++) {
            Arrays.fill(cache, -1);
            N = br.readLine().trim();
            sb.append(memorize(0)).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int classify(int a, int b) {
        String M = N.substring(a, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M.length(); i++) {
            sb.append(M.charAt(0));
        }
        if (M.equals(sb.toString())) return 1;

        boolean progressive = true;
        int diff = M.charAt(1) - M.charAt(0);
        for (int i = 0; i < M.length() - 1; i++) {
            if (M.charAt(i + 1) - M.charAt(i) != diff) {
                progressive = false;
                break;
            }
        }
        if (progressive && Math.abs(diff) == 1) return 2;

        boolean alternating = true;
        for (int i = 0; i < M.length(); i++) {
            if (M.charAt(i) != M.charAt(i % 2)) {
                alternating = false;
                break;
            }
        }
        if (alternating) return 4;

        if (progressive) return 5;

        return 10;
    }

    private static int memorize(int begin) {
        if (begin == N.length()) return 0;
        int ret = cache[begin];
        if (ret != -1) return ret;

        ret = INF;
        for (int i = 3; i <= 5; i++) {
            if (begin + i <= N.length()) {
                ret = Math.min(ret, memorize(begin + i) + classify(begin, begin + i));
            }
        }

        return cache[begin] = ret;
    }
}
