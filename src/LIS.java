import java.util.Arrays;
import java.util.Scanner;

public class LIS {

    private static int helper(int[] dp, int index, int[] nums, int lastIncluded){
        if(dp[index] != -1) return dp[index];
        if(nums[index] <= lastIncluded)
            dp[index] = helper(dp, index+1, nums, lastIncluded);
        else
            dp[index] = Math.max(helper(dp, index+1, nums, nums[index])+1,
                            helper(dp, index+1, nums, lastIncluded));
        return dp[index];

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scan.nextInt();
        }
        //Let dp[i] denote the length of longest increasing sequence in nums[i..n-1]
        int[] dp = new int[n+1];

        //since the implementation is recursive
        Arrays.fill(dp,-1);

        //Base case
        dp[n] = 0;

        //goal is dp[0]
        //Hint : goal should be the thing last computed in the for loops
        helper(dp, 0, nums, Integer.MIN_VALUE);
        System.out.println("Answer : " + dp[0]);

    }
}
