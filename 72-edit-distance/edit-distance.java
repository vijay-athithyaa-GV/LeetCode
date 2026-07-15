import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return dist(n-1,m-1,word1,word2,dp);
    }
    public int dist(int i,int j,String s1,String s2,int dp[][]){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(s1.charAt(i) == s2.charAt(j)){
            return dist(i-1,j-1,s1,s2,dp);
        }
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        return dp[i][j] = Math.min(dist(i-1,j,s1,s2,dp),Math.min(dist(i,j-1,s1,s2,dp),dist(i-1,j-1,s1,s2,dp)))+1;
    }
}