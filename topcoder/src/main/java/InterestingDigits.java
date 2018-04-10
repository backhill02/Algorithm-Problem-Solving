import java.util.ArrayList;
import java.util.List;

public class InterestingDigits {

  public int[] digits(int base) {

    List<Integer> results = new ArrayList<>();

    for (int i = 2; i < base; i++) {
      boolean isOk = true;

      for (int k1 = 0; k1 < base; k1++) {
        for (int k2 = 0; k2 < base; k2++) {
          for (int k3 = 0; k3 < base; k3++) {
            if ((k1 + k2 * base + k3 * base * base) % i == 0 && (k1 + k2 + k3) % i != 0) {
              isOk = false;
              break;
            }
          }
          if (!isOk) {
            break;
          }
        }
        if (!isOk) {
          break;
        }
      }

      if (isOk) {
        results.add(i);
      }
    }

    return results.stream().mapToInt(Integer::intValue).toArray();
  }
}
