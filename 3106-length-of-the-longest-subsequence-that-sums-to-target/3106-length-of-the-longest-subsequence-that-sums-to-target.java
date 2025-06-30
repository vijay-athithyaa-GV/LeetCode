import java.util.*;

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = sub(n-1,nums,target,dp);
        return (ans <= Integer.MIN_VALUE+1)?-1:ans;
    }
    public int sub(int ind,List<Integer> nums,int tar,int dp[][]){
        if(ind == 0){
            if(tar == 0) return 0;
            if(nums.get(0) == tar) return 1;
            else
                return Integer.MIN_VALUE;
        }
        if(dp[ind][tar]!=-1)
            return dp[ind][tar];
        int nottake = 0+sub(ind-1,nums,tar,dp);
        int take = Integer.MIN_VALUE;
        if(nums.get(ind)<=tar)
        {
             int res = 0;
             res = sub(ind-1,nums,tar-nums.get(ind),dp);
             if(res!=Integer.MIN_VALUE)
                take = 1+res;
        }
        dp[ind][tar] = Math.max(nottake,take);
        return dp[ind][tar];
    }
}