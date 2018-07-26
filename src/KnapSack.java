import java.util.Arrays;
import java.util.Scanner;

public class KnapSack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] vals = new int[n];
        int[] weights = new int[n];
        System.out.println("enter values");
        for(int i=0; i<n; i++)
            vals[i]= scan.nextInt();
        System.out.println("enter weights");
        for(int i=0; i<n; i++)
            weights[i]= scan.nextInt();
        System.out.println("Enter capacity");
        int W = scan.nextInt();


        //dp[i][K] denotes maximum value obtained by filling i..n in a knapsack with current capacity K
        int[][] dp = new int[n+1][W+1];

        //Base Case
        Arrays.fill(dp[n],0);
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int i=n-1; i>=0; i--){
            for(int k=1; k<=W; k++){
                if(weights[i] > k){
                    dp[i][k] = dp[i+1][k];
                    continue;
                }
                //recursion relation
                dp[i][k] = Math.max(dp[i+1][k-weights[i]]+vals[i], dp[i+1][k]);
            }
        }

        //goal
        System.out.println("maximum value : " + dp[0][W]);
    }
}
