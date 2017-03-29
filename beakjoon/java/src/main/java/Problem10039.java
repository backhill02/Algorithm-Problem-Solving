import java.util.Scanner;

public class Problem10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
        int sum = 0;
        for (int number : numbers) {
            sum += number > 40 ? number : 40;
        }
        System.out.println(sum / numbers.length);

        sc.close();
    }
}
