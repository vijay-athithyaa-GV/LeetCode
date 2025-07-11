import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = p.length();
        int n2 = s.length();
        Boolean dp[][] = new Boolean[n1+1][n2+1];
        return tab(p,s,dp);
    }
    public boolean mat(int i,int j,String s1,String s2,Boolean dp[][]){
        //base case..
        if(i==0 && j==0)  return true;
        if(i==0 && j>0) return false;
        if(j==0 && i>0){
            for(int k=0;k<i;k++){
                if(s1.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if(dp[i][j]!=null)  return dp[i][j]; 
        //logic..
        if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) =='?'){
            dp[i][j] = mat(i-1,j-1,s1,s2,dp);
            return dp[i][j];
        }
        if(s1.charAt(i-1) == '*'){
            dp[i][j] = mat(i-1,j,s1,s2,dp) || mat(i,j-1,s1,s2,dp);
            return dp[i][j];
        }
        dp[i][j] = false; 
        return dp[i][j];

    }
    public boolean tab(String s1,String s2,Boolean dp[][]){
        int n1 = s1.length();
        int n2 = s2.length();
        dp[0][0] = true;
        for(int j=1;j<=n2;j++)
            dp[0][j] = false;
        for(int i=1;i<=n1;i++){
            boolean flg = true;
            for(int k=1;k<=i;k++){
                if(s1.charAt(k-1) != '*'){
                    flg = false;
                    break;
                }
            }
            dp[i][0] = flg;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) =='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s1.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else
                    dp[i][j] = false; 
            }     
        }
        return dp[n1][n2];
    }
}