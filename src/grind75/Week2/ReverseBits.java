package grind75.Week2;

public class ReverseBits {

    // for a nice O(1) solution -> https://leetcode.com/problems/reverse-bits/solutions/1232842/java-c-0ms-o-1-time-complexity-in-place-detailed-explanation/
    public int reverseBits(int n) {
        int s = 0;
        int i = 0;
        while (i<32) {
            if (n%2 != 0) {
                s+=1 << (31-i);
            }

            i++;
            n = n >> 1;
        }

        return s;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        rb.reverseBits(-3);
    }
}
