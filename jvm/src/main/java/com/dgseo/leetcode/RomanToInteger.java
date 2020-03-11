package com.dgseo.leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new ConcurrentHashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        Stack<Character> chars = s.chars()
                .mapToObj(c -> (char) c).collect(Collectors.toCollection(Stack::new));

        int sum = 0;
        char beforeChar = 0;
        while (!chars.empty()) {
            char c = chars.pop();
            if ((c == 'I' && "VX".contains(String.valueOf(beforeChar))) ||
                    (c == 'X' && "LC".contains(String.valueOf(beforeChar))) ||
                    (c == 'C' && "DM".contains(String.valueOf(beforeChar)))) {
                sum -= romanMap.get(c);
            } else {
                sum += romanMap.get(c);
            }
            beforeChar = c;
        }
        return sum;
    }
}
