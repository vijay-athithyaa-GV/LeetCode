class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length()+word2.length();
        return n-longestCommonSubsequence(word1,word2)*2;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return tab(text1,text2,dp);
    }
    public int tab(String t1,String t2,int dp[][]){
        int n1 = t1.length();
        int n2 = t2.length();
        for(int i=0;i<=n1;i++)
            dp[i][0] = 0;
        for(int j=0;j<=n2;j++)
            dp[0][j] = 0;
        for(int ind1=1;ind1<=n1;ind1++){
            for(int ind2=1;ind2<=n2;ind2++){
                if(t1.charAt(ind1-1) == t2.charAt(ind2-1))
                     dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] =  Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        return dp[n1][n2];
    }
}