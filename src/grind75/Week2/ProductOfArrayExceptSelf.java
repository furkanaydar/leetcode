package grind75.Week2;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] out=new int[nums.length];
        int c=1;

        for (int i=0; i<nums.length; i++) {
            c*=nums[i];
            out[i]=c;
        }

        c=1;

        for (int i=nums.length-1; i>=1; i--) {
            out[i]=out[i-1]*c;
            c*=nums[i];
        }

        out[0]=c;
        return new int[] {};
    }

    public static void main(String[] args) {
        productExceptSelf(new int[] {-1,1,0,-3,3});
    }
}
