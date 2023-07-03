package grind75.Week5;

public class DecodeString {

    public String decode(String s, int l, int r) {
        StringBuilder res= new StringBuilder();
        for (int i=l; i<r; i++) {
            int cs=0;
            while (i<r && Character.isDigit(s.charAt(i))) {
                cs*=10;
                cs+=s.charAt(i++)-'0';
            }

            if (s.charAt(i) == '[') {
                cs = Math.max(1, cs);
                i++;
                int pl=i, cc=1;
                while (i<r && cc>0) {
                    if (s.charAt(i) == ']') cc--;
                    if (s.charAt(i) == '[') cc++;
                    i++;
                }
                res.append(decode(s, pl, --i).repeat(cs));
            } else {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public String decodeString(String s) {
        return decode(s, 0, s.length());
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a]2[bc]"));
        //System.out.println(ds.decodeString("aaa[bc]"));
    }
}
