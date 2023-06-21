package grind75.Week3;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int i=0, j=height.length-1;
        int max=0;
        while (i<j) {
            int cur=Math.min(height[i], height[j]) * (j-i);
            max = Math.max(cur, max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] n = new int[] {1,8,6,2,5,4,8,3,7};
        int[] n2 = new int[] {1,3,2,5,25,24,5};
        System.out.println(maxArea(n2));
    }
}
