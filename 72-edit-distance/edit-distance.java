import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return minDist(word1,word2,n1,n2,dp);
    }
    public int minDist(String s1,String s2,int i,int j,int dp[][]){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            dp[i][j] = minDist(s1,s2,i-1,j-1,dp);
        }
        else{
            dp[i][j] = 1+Math.min(minDist(s1,s2,i,j-1,dp),Math.min(minDist(s1,s2,i-1,j-1,dp),minDist(s1,s2,i-1,j,dp)));
        }    
        return dp[i][j];
    }
}