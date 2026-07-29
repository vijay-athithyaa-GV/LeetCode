import java.util.*;

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        StringBuilder tem = new StringBuilder(s);
        String s2 = tem.reverse().toString();
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++) Arrays.fill(dp[i],0);
        int max = -1;
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(dp[i][j] > max){
                        max = dp[i][j];
                    }
                }else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        // //logic for storing..
        // while(mi >= 0 && mj >= 0){
        //     if(dp[mi][mj] > 0){
        //         st = st+s1.charAt(mi-1);
        //         mi = mi-1;
        //         mj = mj-1;
        //     }
        // }

        // return st;
        return max;
    }
}
