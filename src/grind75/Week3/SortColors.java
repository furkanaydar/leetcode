package grind75.Week3;

public class SortColors {

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void sortColors(int[] nums) {
        int l=0, m=0, r=nums.length-1;

        while (m<r) {
            if (nums[m] == 0) {
                swap(nums, l++, m++);
            } else if(nums[m] == 2) {
                swap(nums, m, r--);
            } else {
                m++;
            }
        }
    }
}
