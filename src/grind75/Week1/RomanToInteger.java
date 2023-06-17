package grind75.Week1;

import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        int res = 0;
        Map<String, Integer> singles = Map.of("V", 5,
                "L", 50,
                "D", 500,
                "M", 1000,
                "C", 100,
                "X", 10,
                "I", 1);

        Map<String, Integer> doubles = Map.of("CD", 400,
                "CM", 900,
                "XL", 40,
                "XC", 90,
                "IV", 4,
                "IX", 9);

        for (int i=0; i<s.length(); i++) {
            if (i+1 < s.length()) {
                String f = "" + s.charAt(i) + s.charAt(i+1);
                if (doubles.containsKey(f)) {
                    i++;
                    res+=doubles.get(f);
                    continue;
                }
            }

            res+=singles.getOrDefault("" + s.charAt(i), 0);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
