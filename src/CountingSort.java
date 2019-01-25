import java.util.Scanner;

/*
Time Complexity of Counting Sort : O(n+k)
n = #ele in input array
k = range of elements in input array
Space Complexity : O(n+k)s
 */

public class CountingSort {
    public void countingSort(int[] nums, int k) {
        int[] counts = new int[k];
        int[] output = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            counts[nums[i]]++;
        for(int i=1; i<counts.length; i++)
            counts[i] = counts[i]+counts[i-1];
        for(int i=0; i<nums.length;i++) {
                output[counts[nums[i]]-1] = nums[i];
                counts[nums[i]]--;

        }
        for(int i=0; i<nums.length; i++)
            nums[i] = output[i];

    }
    public void printArray(int[] nums) {
        for(int i=0; i<nums.length; i++)
            System.out.println(nums[i]);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scan.nextInt();
        int k = scan.nextInt();
        CountingSort cs = new CountingSort();
        cs.countingSort(nums, k);
        cs.printArray(nums);
    }
}
