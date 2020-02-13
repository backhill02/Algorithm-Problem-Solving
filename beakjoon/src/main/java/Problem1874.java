import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int count = 1;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            while (data >= count) {
                stack.add(count++);
                result.add("+");
            }
            if (stack.peek() == data) {
                stack.pop();
                result.add("-");
            } else {
                System.out.print("NO");
                return;
            }
        }
        System.out.print(String.join("\n", result));
    }
}
