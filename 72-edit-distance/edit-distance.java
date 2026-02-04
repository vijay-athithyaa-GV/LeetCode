import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            Arrays.fill(dp[i],0);
        }
        return tab(word1,word2,dp);
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

    public int tab(String s1,String s2,int dp[][]){
        int n1 = s1.length();
        int n2 = s2.length();
        for(int j=0;j<=n2;j++) dp[0][j] = j;
        for(int i=0;i<=n1;i++) dp[i][0] = i;

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }       
            }
        }
        return dp[n1][n2];
    }
}