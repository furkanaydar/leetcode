package grind75.Week1;

public class NumberOf1Bits {
    // memoization?
    /*
        11 = 3
        5 = 2
        2 = 1
        1 = 1
     */
    /*
    -6: 11111111111111111111111111111010
    2^31-1-4-1


    -24: 11111111111111111111111111101000
    2^31-1-1-2-4-16
     */
    public static int hammingWeight(int n) {
        int k, c;
        if (n<0) {
            k = Integer.MAX_VALUE+n+1;
            c = 1;
        } else {
            k = n;
            c = 0;
        }

        while(k>0) {
            c+=k%2;
            k/=2;
        }
        return c;
    }

    // better bit operation solution:
    // https://leetcode.com/problems/number-of-1-bits/solutions/3631866/easy-bit-operator-solution-for-beginners/
    public int betterHammingWeight(int n) {
        int a = 1;
        int counter = 0;

        for(int i = 0; i < 32; i++) {
            if((n & a) != 0) {
                counter++;
            }
            a <<= 1;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight(12));
        System.out.println(hammingWeight(11));

        System.out.println(hammingWeight(128));

    }
}
