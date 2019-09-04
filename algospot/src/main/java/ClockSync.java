import java.util.Stack;

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

    public static void main(String[] args) {
        int[] clocks = {12, 6, 6, 6, 6, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
        press(0, new Stack<>(), clocks);
    }

    private static void press(int ccIndex, Stack<Integer> ccStack, int[] clocks) {
        if (ccIndex == 10) {
            return;
        }

        for (int i = ccIndex; i < 10; i++) {
            changeTime(clocks, ccStack.push(i), 3);
            press(i + 1, ccStack, clocks);
            changeTime(clocks, ccStack.pop(), -3);
        }
    }

    private static void changeTime(int[] clocks, int ccIndex, int addHour) {
        for (int cIndex : CONNECTED_CLOCK[ccIndex]) {
            int change = (clocks[cIndex] + addHour) % 12;
            change = change == 0 ? 12 : change;
            clocks[cIndex] = change;
        }
    }
}
