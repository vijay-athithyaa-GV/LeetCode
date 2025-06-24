import java.util.*;

class Solution {
    public int perfectSum(int[] nums, int target) {
       int n = nums.length;
       int dp[][] = new int[n][target+1];
       for(int i=0;i<n;i++){
           Arrays.fill(dp[i],-1);
       }
       return subset(nums,n-1,target,dp);
    }
    
    public int subset(int[] nums,int ind,int tar,int dp[][]){
        if(ind == 0){
        if(tar == 0 && nums[0] == 0)
            return 2;
        if(nums[ind] == tar || tar == 0)
                return 1;
        return 0;
        }
        if(dp[ind][tar]!=-1)
            return dp[ind][tar];
            
        int notpick = subset(nums,ind-1,tar,dp);
        int pick =0;
        if(nums[ind]<=tar)
            pick = subset(nums,ind-1,tar-nums[ind],dp);
        dp[ind][tar] = notpick+pick;
        return dp[ind][tar];
    }
}