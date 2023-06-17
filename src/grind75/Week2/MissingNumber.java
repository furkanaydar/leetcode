package grind75.Week2;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int r = nums.length;
        int sum = 0;

        for (int i=1; i<=r; i++) {
            sum+=i;
        }

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }
}
