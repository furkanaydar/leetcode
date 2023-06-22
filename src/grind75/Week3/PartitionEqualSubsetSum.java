package grind75.Week3;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int n = Arrays.stream(nums).sum();
        boolean[] d = new boolean[20000];

        if (n%2 == 1) {
            return false;
        }

        d[0] = true;
        for (int num : nums) {
            for (int j = n / 2; j >= 0; j--) {
                if (d[j]) {
                    d[j + num] = true;
                }
            }
        }

        return d[n/2];
    }

    public static void main(String[] args) {

        //System.out.println(canPartition(new int[] {3,3,3,4,5}));
        //System.out.println(canPartition(new int[] {9, 3, 4, 7, 1}));
        System.out.println(canPartition(new int[] {9, 7, 4, 8, 100}));

    }
}
