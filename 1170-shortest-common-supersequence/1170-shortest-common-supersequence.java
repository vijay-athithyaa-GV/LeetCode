import java.util.*;

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int dp[][] = new int[n1+1][n2+1];
        return tab(str1,str2,dp);
    }
    public String tab(String t1,String t2,int dp[][]){
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
        //shortest common supersequence logic...
        int i = n1;
        int j = n2;
        StringBuilder res = new StringBuilder();
        while(i>0 && j>0){
            if(t1.charAt(i-1) == t2.charAt(j-1)){
                res = res.append(t1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                res = res.append(t1.charAt(i-1));
                i--;
            }
            else{
                res = res.append(t2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            res = res.append(t1.charAt(i-1));
            i--;
        }
        while(j>0){
            res = res.append(t2.charAt(j-1));
            j--;
        }
        return res.reverse().toString();
    }
}