import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClockSync {
    private static final int[][] CONNECTED_CLOCK = {
            {0, 1, 2},
            {3, 7, 9, 11},
            {4, 10, 14, 15},
            {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12},
            {0, 2, 14, 15},
            {3, 14, 15},
            {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 9, 13}
    };
    private static int[] clocks = new int[16];
    private static final int MIN = 9999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine().trim());
        StringBuilder result = new StringBuilder();
        for (int t = 0; t < testCnt; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < clocks.length; c++) {
                clocks[c] = Integer.parseInt(st.nextToken());
            }
            int solve = solve(0);
            result.append(solve >= MIN ? -1 : solve).append("\n");
        }
        System.out.print(result);
    }

    private static boolean areAligned() {
        boolean isOk = true;
        for (int clock : clocks) {
            if (clock != 12) {
                isOk = false;
                break;
            }
        }
        return isOk;
    }

    private static int solve(int switchIndex) {
        if (switchIndex == 10) {
            return areAligned() ? 0 : MIN;
        }

        int ret = MIN;
        for (int cnt = 0; cnt < 4; cnt++) {
            ret = Math.min(ret, cnt + solve(switchIndex + 1));
            press(switchIndex);
        }
        return ret;
    }

    private static void press(int switchIndex) {
        for (int cIndex : CONNECTED_CLOCK[switchIndex]) {
            clocks[cIndex] += 3;
            if (clocks[cIndex] >= 15) clocks[cIndex] = 3;
        }
    }
}
