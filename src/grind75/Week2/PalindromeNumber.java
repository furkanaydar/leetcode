package grind75.Week2;

public class PalindromeNumber {

    public static boolean isPalindromeWithArray(int x) {
        if (x<0) {
            return false;
        }

        int[] arr = new int[10];
        int c = 0;
        while (x>0) {
            arr[c++] = x%10;
            x/=10;
        }
        int i=0, j=c-1;

        while (i<j) {
            if (arr[i++] != arr[j--]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(int x) {
        int s=0, t=x;
        while (t>0) {
            s=s*10+t%10;
            t/=10;
        }

        return s == x;
    }

    public static void main(String[] args) {
        isPalindrome(1121);
    }
}
