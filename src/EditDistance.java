import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        int m = s1.length();
        int n = s2.length();

        /*dp[i][j] denotes min #oprns to convert s1[i..m-1] to s2[j..n-1] */
        int[][] dp = new int[m+1][n+1];

        //take care of base cases
        for(int i=0; i<m; i++)
            dp[i][n] = i;       //i insert oprns to s1
        for(int j=0; j<n; j++)
            dp[m][j] = j;   //j delete oprns to s1

        //Goal is dp[0][0]

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]))+1;

            }
        }
        System.out.println("Answer : " + dp[0][0]);

    }
}
