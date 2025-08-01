class Solution {
    public int uniquePaths(int m, int n) { 
        int dp[][] = new int[m][n];
        return tab(m,n,dp);  
    }

    public int Paths(int i,int j,int[][] dp){
        if(i==0 & j==0)
            return 1;
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up = Paths(i-1,j,dp);
        int left = Paths(i,j-1,dp);
        dp[i][j] = up+left;
        return dp[i][j];
    }
    public int tab(int m,int n,int[][] dp){
        dp[0][0] = 1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)
                    dp[0][0] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}