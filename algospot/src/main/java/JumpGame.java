import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JumpGame {
    private static int n;
    private static int[][] board = new int[100][100];
    private static int[][] cache = new int[100][100];

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCnt; t++) {
            n = Integer.parseInt(br.readLine());
            for (int[] arr : cache) {
                Arrays.fill(arr, -1);
            }
            for (int y = 0; y < n; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    board[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(jump(0, 0) == 1 ? "YES" : "NO").append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int jump(int y, int x) {
        if (y >= n || x >= n) return 0;
        if (y == n - 1 && x >= n - 1) return 1;
        int jumpSize = board[y][x];
        int ret = cache[y][x];
        if (ret != -1) return ret;
        return cache[y][x] = (jump(y + jumpSize, x) == 1 || jump(y, x + jumpSize) == 1) ? 1 : 0;
    }
}
