import java.util.Scanner;

public class Problem10809 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    for (int i = (int) 'a'; i <= (int) 'z'; i++) {
      System.out.printf("%d ", s.indexOf((char) i));
    }

    sc.close();
  }
}
