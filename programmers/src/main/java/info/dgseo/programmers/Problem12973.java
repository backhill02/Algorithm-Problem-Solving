package info.dgseo.programmers;

import java.util.Stack;

public class Problem12973 {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        answer = stack.size() > 0 ? 0 : 1;
        System.out.println(answer);
        return answer;
    }
}
