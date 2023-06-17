package grind75.Week1;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        StringBuilder res = new StringBuilder();
        for (int i=0; i<minLen; i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    return res.toString();
                }
            }
            res.append(ch);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }
}
