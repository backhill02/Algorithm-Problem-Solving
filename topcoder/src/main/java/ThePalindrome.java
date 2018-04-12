public class ThePalindrome {

  public int find(String s) {
    String result = s;
    for (int i = s.length() - 1; i >= 0; i--) {
      String reverseResult = new StringBuffer(result).reverse().toString();
      if (result.equals(reverseResult)) {
        break;
      }
      result += s.substring(i - 1, i);
    }
    return result.length();
  }
}
