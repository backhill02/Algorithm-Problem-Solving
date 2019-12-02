import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tiling2 {
    private static final int MOD = 1000000007;
    private static int[] cache = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCnt; t++) {
            Arrays.fill(cache, -1);
            int width = Integer.parseInt(br.readLine().trim());
            sb.append(tiling(width)).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int tiling(int width) {
        if (width <= 1) return 1;
        int ret = cache[width];
        if (ret != -1) return ret;
        return cache[width] = (tiling(width - 2) + tiling(width - 1)) % MOD;
    }
}
