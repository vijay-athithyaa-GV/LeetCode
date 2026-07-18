import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int st = s.length();
        Boolean dp[] = new Boolean[st];
        return word(0,wordDict,s,dp);
    }

    public boolean word(int ind,List<String> dict,String s,Boolean[] dp){
        int n = s.length();
        if(ind == n) return true;
        if(ind>n) return false;
        if(dp[ind]!=null) return dp[ind];
        //here natural backtracking takes place...
        for(int i=0;i<dict.size();i++){
            String s1 = dict.get(i);
            if(s.charAt(ind) == s1.charAt(0) && compareAll(s,ind,s1)){
                if(word(ind+s1.length(),dict,s,dp)){
                    return dp[ind] = true;
                }
            }
        }
        return dp[ind] = false;
    }

    public boolean compareAll(String s,int ind,String s1){
        for(int i=0;i<s1.length() && ind<s.length();i++){
            if(s.charAt(ind++) != s1.charAt(i)) return false;
        }
        return true; 
    }
}