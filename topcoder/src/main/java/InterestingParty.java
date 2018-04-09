import java.util.HashMap;
import java.util.Map;

public class InterestingParty {
    public int bestInvitation(String[] first, String[] second) {
        Map<String, Integer> dic = new HashMap<>();

        for (int i = 0; i < first.length; i++) {
            dic.put(first[i], 0);
            dic.put(second[i], 0);
        }

        for (int i = 0; i < first.length; i++) {
            dic.put(first[i], dic.get(first[i]) + 1);
            dic.put(second[i], dic.get(second[i]) + 1);
        }

        int ans = 0;
        for (String key : dic.keySet()) {
            ans = Math.max(ans, dic.get(key));
        }

        return ans;
    }
}
