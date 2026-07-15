import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        return minPath(n-1,m-1,grid,dp);
    }

    public int minPath(int ind1,int ind2,int[][] grid,int[][] dp){
        if(ind1 == 0 && ind2 == 0) return grid[0][0];
        if(dp[ind1][ind2]!=Integer.MAX_VALUE) return dp[ind1][ind2];
        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;
        if(ind2-1>=0) left = minPath(ind1,ind2-1,grid,dp)+grid[ind1][ind2];
        if(ind1-1>=0) top = minPath(ind1-1,ind2,grid,dp)+grid[ind1][ind2];
        return dp[ind1][ind2] = Math.min(left,top);
    }
}