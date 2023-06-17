package grind75.Week1;

public class SingleNumber {
    /*
     Hint used:
     - XOR of two equal number is 0
     - ^ = XOR
     - 0 ^ N = N
     - A ^ A ^ B ^ B ^ ... ^ D = D
     */
    public static int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {4,1,2,1,2}));
    }
}
