import java.util.Scanner;

public class primematrix {

    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static int  countp(int[][] nums){
        int n =nums.length;
        boolean[][][] dp  = new boolean[n][n][n];
        int count=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isPrime(nums[i][j])) {
                    count++;
                    dp[i][j][1] = true;
                }
            }
        }

        for(int w=2; w<n; w++){
            for(int i=n-w; i>=0; i--){
                for(int j=n-w; j>=0; j--){
                    dp[i][j][w] = dp[i][j][w-1] && dp[i][j+1][w-1] && dp[i+1][j][w-1] && dp[i+1][j+1][w-1];
                    if(dp[i][j][w]) count++;
                }
            }
        }


        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] nums = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                nums[i][j] = scan.nextInt();
        }
        System.out.println(countp(nums));
    }

}
