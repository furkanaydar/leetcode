package grind75.Week2;


public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {

        int j=0;

        while(j<nums.length && nums[j] < 0) {
            j++;
        }

        int i=j-1;
        int c=0;
        int[] res = new int[nums.length];

        while (c<nums.length) {
            if (i<=0) {
                res[c++]=nums[j]*nums[j++];
            } else if (j>=nums.length) {
                res[c++]=nums[i]*nums[i--];
            } else if (Math.abs(nums[i]) <= Math.abs(nums[j])){
                res[c++]=nums[i]*nums[i--];
            } else {
                res[c++]=nums[j]*nums[j++];
            }
        }

        return res;
    }

    public static int[] betterSortedSquares(int[] nums) {
        int i=0, j=nums.length-1, c=nums.length-1;
        int[] res = new int[nums.length];

        while (i<=j) {
            if (nums[i]*nums[i]>=nums[j]*nums[j]) {
                res[c--] = nums[i]*nums[i++];
            } else {
                res[c--] = nums[j]*nums[j--];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        betterSortedSquares(new int[]{-4,-1,0,3,10});
    }
}
