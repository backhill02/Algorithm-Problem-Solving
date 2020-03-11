package com.dgseo.topcoder;

public class FriendScore {

  public int highstScore(String[] friends) {
    int result = 0;
    int n = friends[0].length();
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }

        if (friends[i].charAt(j) == 'Y') {
          cnt++;
        } else {
          for (int k = 0; k < n; k++) {
            if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
              cnt++;
              break;
            }
          }
        }
      }
      result = Math.max(result, cnt);
    }

    return result;
  }
}
