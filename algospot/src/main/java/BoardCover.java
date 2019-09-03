import java.util.Scanner;

public class BoardCover {
    private static final int[][][] COVER_TYPE = {
            {{0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, -1}},
    };
    private static int h;
    private static int w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();
        sc.nextLine();
        StringBuilder result = new StringBuilder();
        for (int t = 0; t < testCnt; t++) {
            h = sc.nextInt();
            w = sc.nextInt();
            sc.nextLine();
            int[][] board = new int[h][w];
            for (int y = 0; y < h; y++) {
                String line = sc.nextLine();
                for (int x = 0; x < w; x++) {
                    if (line.charAt(x) == '.') {
                        board[y][x] = 0;
                    } else {
                        board[y][x] = 1;
                    }
                }
            }
            result.append(cover(board));
            if (t < testCnt - 1) {
                result.append("\n");
            }
        }
        System.out.print(result);
        sc.close();
    }

    private static boolean set(int[][] board, int y, int x, int type, int delta) {
        boolean ok = true;
        for (int i = 0; i < 3; i++) {
            int ny = y + COVER_TYPE[type][i][0];
            int nx = x + COVER_TYPE[type][i][1];
            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
                ok = false;
            } else if ((board[ny][nx] += delta) > 1) {
                ok = false;
            }
        }
        return ok;
    }

    private static int cover(int[][] board) {
        int y = -1, x = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) break;
        }
        if (y == -1) return 1;
        int ret = 0;
        for (int type = 0; type < 4; type++) {
            if (set(board, y, x, type, 1)) {
                ret += cover(board);
            }
            set(board, y, x, type, -1);
        }
        return ret;
    }
}
