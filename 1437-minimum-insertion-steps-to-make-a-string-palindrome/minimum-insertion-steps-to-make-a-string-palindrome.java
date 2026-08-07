import java.util.*;

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String s1 = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        //return n-lcs(n-1,n-1,s,s1,dp);
        return n-tab(s,s1,dp);
    }

    public int lcs(int i,int j,String s1,String s2,int dp[][]){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1+lcs(i-1,j-1,s1,s2,dp);
        }
        else{
            return dp[i][j] = Math.max(lcs(i-1,j,s1,s2,dp),lcs(i,j-1,s1,s2,dp));
        }

    }

    public int tab(String s1,String s2,int dp[][]){
        int n = s1.length();
        for(int i=0;i<=n;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}