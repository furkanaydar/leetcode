package grind75.Week1;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        StringBuilder b = new StringBuilder();
        for (Character c: s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                b.append(c);
            } else if (c >= '0' && c <= '9') {
                b.append(c);
            }
        }

        String cleaned = b.toString();
        int l=0, r=cleaned.length()-1;
        while (l < r) {
            if (cleaned.charAt(l) != cleaned.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
