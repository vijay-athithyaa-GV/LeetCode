import java.util.*;
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++) Arrays.fill(dp[i],0);
        return tab(text1,text2,dp);
    }

    public int lcs(String s1,String s2,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = 1+lcs(s1,s2,i-1,j-1,dp);
        }
        else{
            dp[i][j] = Math.max(lcs(s1,s2,i-1,j,dp),lcs(s1,s2,i,j-1,dp));
        }
        return dp[i][j];
    }

    public int tab(String s1,String s2,int[][] dp){
        int n1 = s1.length();
        int n2 = s2.length();
        for(int i=0;i<n1;i++)dp[i][0] = 0;
        for(int j=0;j<n2;j++)dp[0][j] = 0;

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n1][n2];   
    }
}