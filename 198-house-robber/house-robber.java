import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return robHouse(nums,n-1,dp);
    }

    public int robHouse(int arr[],int ind,int dp[]){
        if(ind == 0) return arr[ind];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int take = arr[ind]+robHouse(arr,ind-2,dp);
        int nottake = robHouse(arr,ind-1,dp);
        dp[ind] = Math.max(take,nottake);
        return dp[ind];
    }
}