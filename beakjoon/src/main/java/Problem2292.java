import java.util.Scanner;

public class Problem2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 1;
        int sum = 1;
        while (true) {
            if (sum >= n) {
                break;
            }
            sum += cnt * 6;
            cnt++;
        }

        System.out.println(cnt);

        sc.close();
    }
}
