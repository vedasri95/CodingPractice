import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        int m = s1.length();
        int n = s2.length();

        //dp[i][j] denotes the length of LCS in s1[i..m-1] and s2[i..n-1]
        int[][] dp = new int[m+1][n+1];

        //Take care of base cases
        for(int i=0; i<m; i++)
            dp[i][n] = 0;
        for(int j=0; j<n; j++)
            dp[m][j] = 0;

        //goal is to compute dp[0][0]

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(s1.charAt(i)==s2.charAt(j)){ //if the current chars are equal, include them in LCS
                    dp[i][j] = dp[i+1][j+1]+1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i+1][j], //ignore current char in s1
                        Math.max(dp[i][j+1],    //ignore current char in s2
                                dp[i+1][j+1])); //ignore current chars in s1 and s2
            }
        }
        System.out.println("Length of LCS: " + dp[0][0]);
    }
}
