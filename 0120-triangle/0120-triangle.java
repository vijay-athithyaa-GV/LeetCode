import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return Tri(0,0,triangle,dp);
    }
    public int Tri(int i,int j,List<List<Integer>> t,int[][] dp){
        int n = t.size();
        if(i==n-1)
            return t.get(n-1).get(j);
        if(dp[i][j]!=-1)
            return dp[i][j];
        int d = t.get(i).get(j)+Tri(i+1,j,t,dp);
        int dg = t.get(i).get(j)+Tri(i+1,j+1,t,dp);
        dp[i][j] = Math.min(d,dg);
        return dp[i][j];
    }
}