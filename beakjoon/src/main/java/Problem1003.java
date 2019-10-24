import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1003 {

    private static int[][] cache = new int[41][2];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCnt; t++) {
            for (int c = 0; c < cache.length; c++) {
                Arrays.fill(cache, new int[]{-1, -1});
            }
            int[] solve = solve(Integer.parseInt(br.readLine()));
            sb.append(solve[0]).append(" ").append(solve[1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int[] solve(int n) {
        if (cache[n][0] != -1 && cache[n][1] != -1) return cache[n];
        if (n == 0) {
            return cache[n] = new int[]{1, 0};
        } else if (n == 1) {
            return cache[n] = new int[]{0, 1};
        } else {
            int[] solve1 = solve(n - 2);
            int[] solve2 = solve(n - 1);
            return cache[n] = new int[]{solve1[0] + solve2[0], solve1[1] + solve2[1]};
        }
    }
}
