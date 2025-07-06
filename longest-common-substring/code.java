// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
       int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1+1][n2+1];
        return tab(s1,s2,dp);
    }
     public int tab(String t1,String t2,int dp[][]){
        int n1 = t1.length();
        int n2 = t2.length();
        for(int i=0;i<=n1;i++)
            dp[i][0] = 0;
        for(int j=0;j<=n2;j++)
            dp[0][j] = 0;
        int ans = 0;
        for(int ind1=1;ind1<=n1;ind1++){
            for(int ind2=1;ind2<=n2;ind2++){
                if(t1.charAt(ind1-1) == t2.charAt(ind2-1)){
                     dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
                     ans = Math.max(ans,dp[ind1][ind2]);
                }
                else
                    dp[ind1][ind2] = 0;
            }
        }
        return ans;
}}