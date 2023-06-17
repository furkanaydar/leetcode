package grind75.Week1;

public class FirstBadVersion {

    static int first;

    static boolean isBadVersion(int version) {
        return version>=first;
    }

    public static int firstBadVersion(int n) {
        int l=1, r=n;

        while (l<r) {
            int mid = l+(r-l)/2;
            if (isBadVersion(mid)) {
                r=mid;
            } else {
                l=mid+1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        first = 2;
        System.out.println(firstBadVersion(5));
    }
}
