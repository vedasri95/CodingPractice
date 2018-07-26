import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read input
        int n = scan.nextInt();
        int sum  = scan.nextInt();
        int[] coins = new int[n];
        for(int i=0; i<n; i++)
            coins[i]= scan.nextInt();

        //dp[i][k] denotes #ways of making change for coins from i..n to sum up for k
        int[][] dp = new int[n+1][sum+1];
        //Base cases
        Arrays.fill(dp[n], 0);
        //When sum=0 #ways to make change =0 (Not to include any coins)
        for(int i=0; i<=n; i++)
            dp[i][0] = 1;

        for(int i=n-1; i>=0; i--){
            for(int k=0; k<=sum; k++){
                //check if you cannot use any coins of this type
                if(coins[i]>k){
                    dp[i][k] = dp[i+1][k];
                    continue;
                }
                //You can use any number of coins of current denomination. Add the number of ways by considering all the number of coins possible
                int max = k/coins[i];
                for(int j=0; j<=max; j++){
                    if(j*coins[i] <= k)
                        dp[i][k] += dp[i+1][k-j*coins[i]];
                }
            }
        }
        //Goal
        System.out.println(dp[0][sum]);
    }
}
