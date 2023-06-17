package grind75.Week1;

public class BackspaceStringCompare {

    public static String drill(String inp) {
        int i=inp.length()-1;
        StringBuilder r = new StringBuilder();
        while (i>=0) {

            if (inp.charAt(i) == '#') {
                int sc=1;
                i--;
                while (sc > 0 && i>=0) {
                    if (inp.charAt(i) == '#') {
                        sc++;
                    } else {
                        sc--;
                    }
                    i--;
                }
            }

            if (i>=0 && inp.charAt(i) != '#') {
                r.append(inp.charAt(i));
                i--;

            }

        }

        return r.toString();
    }

    public static boolean backspaceCompare(String s, String t) {
        System.out.println(drill(s));
        System.out.println(drill(t));
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));

        System.out.println(backspaceCompare("ab##", "c#d#"));

    }
}
