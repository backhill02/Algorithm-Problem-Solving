import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boggle {
    private static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static char[][] board = new char[5][5];

    public static void main(String[] args) throws IOException {
        StringBuilder ret = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCnt; t++) {
            for (int b = 0; b < 5; b++) {
                board[b] = br.readLine().toCharArray();
            }
            int wordCnt = Integer.parseInt(br.readLine());
            for (int w = 0; w < wordCnt; w++) {
                String word = br.readLine();
                boolean hasWord = false;
                for (int y = 0; y < 5; y++) {
                    for (int x = 0; x < 5; x++) {
                        if(hasWord(y, x, word)) {
                            hasWord = true;
                            break;
                        }
                    }
                    if(hasWord) break;
                }
                ret.append(word).append(" ").append(hasWord ? "YES" : "NO").append("\n");
            }
        }
        System.out.print(ret);
    }

    private static boolean hasWord(int y, int x, String word) {
        if (y < 0 || y >= 5 || x < 0 || x >= 5) return false;
        if (word.charAt(0) != board[y][x]) return false;
        if (word.length() == 1) return true;

        for (int i = 0; i < 8; i++) {
            if (hasWord(y + dy[i], x + dx[i], word.substring(1))) return true;
        }
        return false;
    }
}
