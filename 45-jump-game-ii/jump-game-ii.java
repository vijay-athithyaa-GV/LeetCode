import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return canj(0,nums,dp);
    }

    public int canj(int ind,int nums[],int dp[]){
        int n = nums.length;
        if(ind == n-1) return 0;
        if(nums[ind] == 0) return Integer.MAX_VALUE;
        if(dp[ind]!=-1) return dp[ind];
        int min = Integer.MAX_VALUE;
        for(int i=ind+1;i<=Math.min(n-1,nums[ind]+ind);i++){
            int take = canj(i,nums,dp);
            if(take != Integer.MAX_VALUE)min = Math.min(min,1+take);  
        }
        dp[ind] =  min;
        return dp[ind];
    }
}