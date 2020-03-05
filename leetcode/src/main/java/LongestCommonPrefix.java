import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"ca", "a"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        String minStr = Arrays.stream(strs)
                .min(Comparator.comparingInt(String::length))
                .orElse("");

        for (int i = 0; i < minStr.length(); i++) {
            String prefix = minStr.substring(0, minStr.length() - i);
            boolean isCommonPrefix = true;
            for (String str : strs) {
                if (!str.substring(0, prefix.length()).equals(prefix)) {
                    isCommonPrefix = false;
                }
            }
            if (isCommonPrefix) {
                result = prefix;
                break;
            }
        }

        return result;
    }
}
