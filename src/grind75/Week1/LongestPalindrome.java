package grind75.Week1;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] chars = new int[60];

        for (Character c: s.toCharArray()) {
            chars[c-65]++;
        }

        int res = 0;
        boolean addOne = false;

        for (int i=0; i<60; i++) {
            if (chars[i]%2 == 0) {
                res += chars[i];
            } else {
                res += chars[i]-1;
                addOne = true;
            }
        }

        if (addOne) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
