import java.util.*;

class Solution {
    int cnt = 0;
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1]; 
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return path(m-1,n-1,dp);
    }

    public int path(int n,int m,int dp[][]){
        if(n == 0 && m == 0) return 1;
        if(n < 0 || m < 0) return 0;
        if(dp[n][m]!=-1) return dp[n][m]; 
        int top = path(n-1,m,dp);
        int left = path(n,m-1,dp);
        dp[n][m] = top+left;
        return dp[n][m];
    }
}