package com.dgseo.topcoder;

import java.util.ArrayList;
import java.util.List;

public class InterestingDigits {

  public int[] digits(int base) {

    List<Integer> results = new ArrayList<>();

    for (int i = 2; i < base; i++) {
      if ((base - 1) % i == 0) {
        results.add(i);
      }
    }

    return results.stream().mapToInt(Integer::intValue).toArray();
  }
}
