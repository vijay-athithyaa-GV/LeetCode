import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
      int n1 = word1.length();
      int n2 = word2.length();
      int dp[][] = new int[n1][n2];
      for(int i=0;i<n1;i++)
        Arrays.fill(dp[i],-1);
      return minD(n1-1,n2-1,word1,word2,dp);  
    }
    public int minD(int i,int j,String s1,String s2,int dp[][]){
        if(i<0) return j+1;//when s1 get exhausted..
        if(j<0) return i+1;//when s2 get exhausted..
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return minD(i-1,j-1,s1,s2,dp);
        int a1 = 1+minD(i,j-1,s1,s2,dp);
        int a2 = 1+minD(i-1,j,s1,s2,dp);
        int a3 = 1+minD(i-1,j-1,s1,s2,dp);
        dp[i][j] = Math.min(a1,Math.min(a2,a3));
        return dp[i][j];
    }
}