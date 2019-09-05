import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Picnic {
    private static int n;
    private static int m;
    private static boolean[][] areFriends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine().trim());
        StringBuilder result = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < testCnt; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            areFriends = new boolean[10][10];
            for (int j = 0; j < m; j++) {
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                areFriends[y][x] = areFriends[x][y] = true;
            }
            result.append(countPairs(new boolean[10])).append("\n");
        }
        System.out.print(result);
    }

    private static int countPairs(boolean[] taken) {
        int firstFree = -1;
        for (int i = 0; i < n; i++) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }
        if (firstFree == -1) return 1;
        int result = 0;
        for (int pairWith = firstFree + 1; pairWith < n; pairWith++) {
            if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
                taken[firstFree] = taken[pairWith] = true;
                result += countPairs(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return result;
    }
}
