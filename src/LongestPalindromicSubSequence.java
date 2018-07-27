import java.util.Scanner;

public class LongestPalindromicSubSequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int n = s.length();

        //L[i][j] denotes longest palindromic sequence in s[i..]
        int[][] L = new int[n+1][n];

        //Base case. (Sequence with length 1)
        for(int i=0; i<n; i++)
            L[i][i] = 1;

        //take care of for loop boundaries.
        //Hint : Your goal should probably be the last computed thing in the loops
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){

                //Recursion relation
                if(s.charAt(i)==s.charAt(j))
                    L[i][j] = 2+L[i+1][j-1];
                else
                    L[i][j] = Math.max(L[i+1][j], L[i][j-1]);

            }
        }

        //Goal : L[0][1]
        System.out.println("Answer : " + L[0][n-1]);
    }
}
