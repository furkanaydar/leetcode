package grind75.Week3;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    static int ml=0, mr=0, max=1;
    public static String longestPalindrome(String s) {
        boolean[][] d = new boolean[s.length()][s.length()];

        for (int i=1; i<s.length(); i++) {
            for (int j=0; j<i; j++) {
                d[i][j] = false;
            }
        }

        for (int i=0; i<s.length(); i++) {
            d[i][i] = true;
        }

        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i+1; j<s.length(); j++) {
                d[i][j] = s.charAt(i) == s.charAt(j);

                if (j > i+1) {
                    d[i][j] &= d[i+1][j-1];
                }

                if (d[i][j] && j-i+1>max) {
                    max=j-i+1;
                    ml=i;
                    mr=j;
                }
            }
        }

        return s.substring(ml, mr+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
