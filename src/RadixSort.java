import java.util.Scanner;

public class RadixSort {
    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int n: nums){
            if(n>max)
                max=n;
        }
        return max;
    }

    private void countingSort(int[] nums, int exp){
            int[] output = new int[nums.length];
            int[] counts = new int[10];

            for(int i=0; i<nums.length; i++){
                counts[(nums[i]/exp)%10]++;
            }
            for(int i=1; i<counts.length; i++){
                counts[i] = counts[i]+counts[i-1];
            }

            for(int i=nums.length-1; i>=0; i--){
                output[counts[(nums[i]/exp)%10]-1] = nums[i];
                counts[(nums[i]/exp)%10]--;
            }
            for(int i=0; i<nums.length; i++){
                nums[i] = output[i];
            }
    }
    public static void printArray(int[] nums){
        for(int i=0; i<nums.length; i++)
            System.out.println(nums[i]);
    }
    public void radixSort(int[] nums){
        int max = getMax(nums);
        for(int exp=1; max/exp>0; exp=exp*10){
            countingSort(nums, exp);
            printArray(nums);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scan.nextInt();
        RadixSort rs = new RadixSort();
        rs.radixSort(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
}
