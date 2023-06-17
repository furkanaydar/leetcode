package grind75.Week1;

public class AddBinary {
    /*

    1010
    1011

    10101

    11
    1

    100


    1011
    1011
     10110
    10110

    110 = 6
    11 = 3

    1001
     */

    public static String equalize(String x, String y) {
        if (x.length() < y.length()) {
            return "0".repeat(y.length() - x.length()) +x;
        }

        return x;
    }

    public static String addBinary(String a, String b) {
        a = equalize(a, b);
        b = equalize(b, a);

        int it=a.length()-1;
        StringBuilder res= new StringBuilder();
        boolean remainder = false;

        while (it>=0) {
            int s = a.charAt(it)-'0'+b.charAt(it)-'0';
            res.append((s + (remainder ? 1 : 0)) % 2);
            remainder = s+(remainder? 1:0)>=2;
            /*
                0 1 F -> 1 0
                0 1 T -> 0 T
                1 1 F -> 0 T
                1 1 T -> 1 T
                0 0 F -> 0 F
                0 0 T -> 1 F
             */
            it--;
        }

        if (remainder) {
            return ("1" + res.reverse());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("110", "0"));
        System.out.println(addBinary("111", "11"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "1"));

    }
}
