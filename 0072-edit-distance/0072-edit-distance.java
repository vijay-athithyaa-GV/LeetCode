import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
      int n1 = word1.length();
      int n2 = word2.length();
      int dp[][] = new int[n1+1][n2+1];
      return tab(word1,word2,dp);  
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
    public int tab(String s1,String s2,int dp[][]){
        int n1 = s1.length();
        int n2 = s2.length();
        for(int i=1;i<=n1;i++)
            dp[i][0] = i; 
        for(int j=0;j<=n2;j++)
            dp[0][j] = j;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] =  dp[i-1][j-1];
                else{
                    int a1 = 1+dp[i][j-1];
                    int a2 = 1+dp[i-1][j];
                    int a3 = 1+dp[i-1][j-1];
                    dp[i][j] = Math.min(a1,Math.min(a2,a3));
                }
            }
        }
        return dp[n1][n2];
    }
}