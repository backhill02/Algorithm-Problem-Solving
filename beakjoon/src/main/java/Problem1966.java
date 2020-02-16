import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Problem1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int m = Integer.parseInt(st.nextToken());

            List<Integer> arr = Arrays.stream(br.readLine().trim().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            sb.append(solve(m, arr));
            if (i < t - 1) {
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static int solve(int m, List<Integer> arr) {
        Queue<Document> queue = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            queue.add(new Document(i, arr.get(i)));
        }

        int count = 0;
        while (true) {
            List<Integer> priorities = queue.stream()
                    .map(Document::getPriority).collect(Collectors.toList());
            int maxPriority = Collections.max(priorities);

            Document document = queue.poll();
            if (maxPriority == document.getPriority()) {
                count++;
                if (m == document.getIndex()) {
                    break;
                }
            } else {
                queue.add(document);
            }
        }

        return count;
    }

    private static class Document {
        private int index;
        private int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public int getIndex() {
            return index;
        }

        public int getPriority() {
            return priority;
        }
    }
}
