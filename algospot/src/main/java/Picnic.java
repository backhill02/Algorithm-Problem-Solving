import java.util.Scanner;

public class Picnic {
    private static int n;
    private static int m;
    private static boolean[][] areFriends;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();
        StringBuilder result = new StringBuilder();
        sc.nextLine();
        for (int i = 0; i < testCnt; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();
            areFriends = new boolean[10][10];
            for (int j = 0; j < m; j++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                areFriends[y][x] = areFriends[x][y] = true;
            }
            sc.nextLine();
            result.append(countPairs(new boolean[10]));
            if(i < testCnt -1) {
                result.append("\n");
            }
        }
        System.out.print(result);
        sc.close();
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
