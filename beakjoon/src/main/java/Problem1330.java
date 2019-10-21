import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    private static String solve(int a, int b) {
        if (a > b) return ">";
        if (a < b) return "<";
        else return "==";
    }
}
