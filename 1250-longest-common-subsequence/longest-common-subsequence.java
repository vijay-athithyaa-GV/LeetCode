import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        //return lcs(n,m,text1,text2,dp);
         for(int i=0;i<=text1.length();i++) dp[i][0] = 0;
        for(int i=0;i<=text2.length();i++) dp[0][i] = 0;
        
        //if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }   
        }
        return dp[n][m];
    }

    public int lcs(int ind1,int ind2,String text1,String text2,int[][] dp){
        int n = text1.length();
        int m = text2.length();
        //if(ind1<0 || ind2<0) return 0;
        for(int i=0;i<=text1.length();i++) dp[i][0] = 0;
        for(int i=0;i<=text2.length();i++) dp[0][i] = 0;
        
        //if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;i++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }   
        }
        return dp[n][m];
    }
}