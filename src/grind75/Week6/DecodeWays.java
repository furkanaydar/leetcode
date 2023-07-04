package grind75.Week6;

public class DecodeWays {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] d = new int[s.length()+1];
        d[0] = d[1] = 1;
        for (int j=2; j<=s.length(); j++) {
            if (s.charAt(j-1) != '0') {
                d[j] += d[j-1];
            }

            int gn = (s.charAt(j - 2) - '0') * 10 + (s.charAt(j-1) - '0');
            if (gn>=10 && gn<=26) {
                d[j] += d[j-2];
            }
        }
        return d[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("2611055971756562"));

    }
}
