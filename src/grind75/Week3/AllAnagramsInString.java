package grind75.Week3;

import java.util.ArrayList;
import java.util.List;

public class AllAnagramsInString {

    public static void compareAndAdd(String s, String p, int[] cs, int[] cp, List<Integer> r, int start) {
        for (int j=0; j<26; j++) {
            if (cs[j] != cp[j]) {
                return;
            }
        }

        r.add(start);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] cs = new int[26];
        int[] cp = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i=0; i<p.length(); i++) {
            cp[p.charAt(i)-97]++;
            if (i<s.length()) {
                cs[s.charAt(i)-97]++;
            }
        }

        compareAndAdd(s, p, cs, cp, res, 0);

        for (int i=p.length(); i<s.length(); i++) {
            cs[s.charAt(i)-97]++;
            cs[s.charAt(i-p.length())-97]--;
            compareAndAdd(s, p, cs, cp, res, i-p.length()+1);
        }

        return res;
    }

    public static void main(String[] args) {
        findAnagrams("aabb", "ab");
        findAnagrams("cbaebabacd", "abc");

    }
}
