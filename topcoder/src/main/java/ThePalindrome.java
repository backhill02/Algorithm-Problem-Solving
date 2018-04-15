public class ThePalindrome {

  public int find(String s) {
    for (int i = s.length(); ; i++) {
      boolean flag = true;

      for (int j = 0; j < s.length(); j++) {
        if ((i - j - 1) < s.length() && s.charAt(i - j - 1) != s.charAt(j)) {
          flag = false;
          break;
        }
      }
      if (flag) {
        return i;
      }
    }
  }
}
