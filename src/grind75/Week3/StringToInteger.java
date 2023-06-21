package grind75.Week3;


public class StringToInteger {

    public static int myAtoi(String s) {
        s = s.stripLeading();
        int start=0, end=0;
        boolean negative=false;

        if (s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.charAt(start) == '-') {
                negative=true;
            }

            start++;
        }

        if (start >= s.length()) {
            return 0;
        }

        if (!Character.isDigit(s.charAt(start))) {
            return 0;
        }

        boolean incrementStart=true;
        for (int i=start; i<s.length() && Character.isDigit(s.charAt(i)); i++, end=i-1) {
            if (s.charAt(i) == '0' && incrementStart) {
                start=i;
            } else if (Character.isDigit(s.charAt(i))) {
                incrementStart = false;
            }
        }

        int c=1, sum=0;
        int overflowResult = negative ? -1 * Integer.MAX_VALUE-1 : Integer.MAX_VALUE;
        for (int i=end; i>=start; i--) {
            int curDigit = s.charAt(i)-'0';
            if (c == 1000000000) {
                if (i!=start || curDigit>2) {
                    return overflowResult;
                }
            }

            int remainingToOverflow=Integer.MAX_VALUE-sum;
            if (c*curDigit>remainingToOverflow) {
                return overflowResult;
            }

            sum+=c*curDigit;

            if (c > Integer.MAX_VALUE/10 && i>start) {
                return overflowResult;
            }

            c*=10;
        }

        return negative ? -1*sum:sum;
    }

    public static void main(String[] args) {
        myAtoi("-6147483648");
    }
}
