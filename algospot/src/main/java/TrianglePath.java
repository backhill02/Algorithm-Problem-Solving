import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TrianglePath {

    private static int n;
    private static int[][] triangle = new int[100][100];
    private static int[][] cache = new int[100][100];

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCnt; t++) {
            n = Integer.parseInt(br.readLine());
            for (int[] ints : cache) {
                Arrays.fill(ints, -1);
            }
            for (int y = 0; y < n; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = 0;
                while (st.hasMoreTokens()) {
                    triangle[y][x++] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(path(0, 0)).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int path(int y, int x) {
        if (y == n - 1) return triangle[y][x];
        if (cache[y][x] != -1) return cache[y][x];
        return cache[y][x] = Math.max(path(y + 1, x), path(y + 1, x + 1)) + triangle[y][x];
    }
}
