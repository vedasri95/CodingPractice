import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxLengthPairChain {
    private static int helper(int[][] pairs, int[] dp, int k, int i){
        if(i==pairs.length-1) return 1;
        if(pairs[i][0] <= k)
            dp[i] = helper(pairs, dp, k, i+1);
        else {

            dp[i] = Math.max(1+helper(pairs,dp, pairs[i][1], i+1), helper(pairs, dp, k, i+1));
        }
        return dp[i];

    }
    public static class CustomComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            Integer n1 = (Integer) a[0];
            Integer n2 = (Integer) b[0];
            return n1.compareTo(n2); //natural order needed. So use compareTo method
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] pairs = new int[n][2];
        for(int i=0; i<n;i++){
            pairs[i][0] = scan.nextInt();
            pairs[i][1] = scan.nextInt();
        }
        CustomComparator comp = new CustomComparator();
        Arrays.sort(pairs, comp);
        int[] dp = new int[n+1];

        dp[n]= 0;
        helper(pairs, dp, Integer.MIN_VALUE,0);
        System.out.println(dp[0]);
    }
}

