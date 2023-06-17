package grind75.Week1;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] h = new int[27];

        for (Character c: s.toCharArray()) {
            h[c-97]++;
        }

        for (Character c: t.toCharArray()) {
            h[c-97]--;
        }

        for (int i=0; i<27; i++) {
            if (h[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("a", "ab"));
    }
}
