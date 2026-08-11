import java.util.*;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],0);

        for(int i=0;i<n;i++){
            dp[i][0] = matrix[i][0]-'0';
            max = Math.max(dp[i][0],max);
        }
        for(int i=0;i<m;i++){
            dp[0][i] = matrix[0][i]-'0';
           // System.out.println(dp[0][i]);
            max = Math.max(dp[0][i],max);
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}