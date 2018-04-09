import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem1316 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();

    int result = 0;
    for (int i = 0; i < n; i++) {
      if (isGroupWord(sc.nextLine())) {
        result++;
      }
    }
    System.out.println(result);

    sc.close();
  }

  private static boolean isGroupWord(String word) {
    Set<Character> charSet = new HashSet<>();

    char beforeChar = 0;
    for (char c : word.toCharArray()) {
      if (beforeChar != c) {
        if (charSet.contains(c)) {
          return false;
        }
        charSet.add(c);
      }
      beforeChar = c;
    }

    return true;
  }
}
