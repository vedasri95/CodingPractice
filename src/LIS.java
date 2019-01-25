import java.util.Arrays;
import java.util.Scanner;

public class LIS {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] vals = new int[n];
        for(int i=0; i<n; i++)
            vals[i] = scan.nextInt();

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            max = Math.max(max, vals[i]);
        max++;

        //dp[i] length of longest increasing seq from val[i..n-1]
        int[][] dp = new int[n+1][max+1];



        for(int i=n-1; i>=0; i--){
            for(int k=max; k>=0; k--){

            }
        }
    }
}
