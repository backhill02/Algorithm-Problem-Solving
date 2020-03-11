package com.dgseo.topcoder;

public class KiwiJuiceEasy {

  public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
    for (int i = 0; i < fromId.length; i++) {
      int f = fromId[i];
      int t = toId[i];

      int sum = bottles[f] + bottles[t];
      bottles[t] = Math.min(capacities[t], sum);
      bottles[f] = sum - bottles[t];
    }

    return bottles;
  }
}
