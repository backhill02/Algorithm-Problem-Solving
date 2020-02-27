import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem4195 {
    private static Map<String, String> parentMap;
    private static Map<String, Integer> countMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            int f = Integer.parseInt(br.readLine());
            parentMap = new HashMap<>();
            countMap = new HashMap<>();
            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                parentMap.putIfAbsent(a, a);
                parentMap.putIfAbsent(b, b);
                countMap.putIfAbsent(a, 1);
                countMap.putIfAbsent(b, 1);
                union(a, b);
                System.out.println(countMap.get(findParent(a)));
            }
        }
    }

    private static String findParent(String child) {
        String parent = parentMap.get(child);
        if (!child.equals(parent)) {
            parent = findParent(parent);
            parentMap.put(child, parent);
        }
        return parent;
    }

    private static void union(String a, String b) {
        String parentA = findParent(a);
        String parentB = findParent(b);

        if (!parentA.equals(parentB)) {
            parentMap.put(parentB, parentA);
            countMap.computeIfPresent(parentA, (k, v) -> countMap.get(parentB) + v);
        }
    }
}
