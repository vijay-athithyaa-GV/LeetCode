import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
       String rev = new StringBuilder(s).reverse().toString();
       int dp[][] = new int[n+1][n+1];
       for(int i=0;i<=n;i++){
        Arrays.fill(dp[i],-1);
       } 
       return tab(s,rev,dp);
    }
    public int lcs(int i,int j,String s1,String s2,int dp[][]){
        if(i==0 || j==0)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1))
            dp[i][j] = 1+lcs(i-1,j-1,s1,s2,dp);
        else
            dp[i][j] = Math.max(lcs(i,j-1,s1,s2,dp),lcs(i-1,j,s1,s2,dp));
        return dp[i][j];
    }
    public String tab(String s1,String s2,int dp[][]){
        int n = s1.length();
        int maxlen = 0;
        int endind = 0;
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<=n;i++) dp[i][0] = 0;
        for(int j=0;j<=n;j++) dp[0][j] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    int ori = i-dp[i][j];
                    int reve = n - j;
                    //logic for substring...
                    if(ori == reve && dp[i][j]>maxlen){
                        maxlen = dp[i][j];
                        endind = i;
                    }
                }
                else
                    dp[i][j] = 0;
            }
        }
        return s1.substring(endind-maxlen,endind);
    }
}