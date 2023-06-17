package grind75.Week2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int l=0, r=0;
        Set<Character> set = new HashSet<>();
        int res=0;

        while (l<s.length() && r<s.length()) {
            if (set.contains(s.charAt(r))) {
                while (s.charAt(l) != s.charAt(r)) {
                    set.remove(s.charAt(l++));
                }

                l++;
                set.remove(s.charAt(r));
            } else {
                set.add(s.charAt(r++));
                res=Math.max(r-l+1, res);
            }
        }

        return res-1;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

        System.out.println(lengthOfLongestSubstring("tmmzuxt"));

    }
}
