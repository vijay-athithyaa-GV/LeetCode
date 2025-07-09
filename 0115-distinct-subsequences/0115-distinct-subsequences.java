import java.util.*;

class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int dp[][] = new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return dis(n1-1,n2-1,s,t,dp);
    }
    public int dis(int i,int j,String s1,String s2,int dp[][]){
        //base..
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            dp[i][j] = dis(i-1,j-1,s1,s2,dp)+dis(i-1,j,s1,s2,dp);
        else
            dp[i][j] = dis(i-1,j,s1,s2,dp);
        return dp[i][j];
    }
}