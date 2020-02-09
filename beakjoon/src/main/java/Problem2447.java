import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                print(y, x);
            }
            System.out.print("\n");
        }
    }

    public static void print(int y, int x) {
        while (y > 0 && x > 0) {
            if (y % 3 == 1 && x % 3 == 1) {
                System.out.print(" ");
                return;
            }
            y /= 3;
            x /= 3;
        }
        System.out.print("*");
    }
}
