import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ploblem2920 {
    public static void main(String[] args) throws IOException {
        boolean asc = true;
        boolean desc = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 1; i < 8; i++) {
            if (arr.get(i) > arr.get(i - 1)) {
                desc = false;
            } else {
                asc = false;
            }
        }

        if (asc) {
            System.out.println("ascending");
        } else if (desc) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
