import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(Integer.parseInt(br.readLine())));
    }

    private static int solve(int n) {
        if (n < 1) return 1;
        return n * solve(n - 1);
    }
}
