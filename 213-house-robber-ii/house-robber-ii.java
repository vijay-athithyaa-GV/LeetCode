import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int dp1[] = new int[n+1];
        int dp2[] = new int[n+1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(robHouse(nums,1,n-1,dp1),robHouse(nums,0,n-2,dp2));
    }

    public int robHouse(int arr[],int start,int ind,int dp[]){
        if(ind == start) return arr[ind];
        if(ind<start) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int take = arr[ind]+robHouse(arr,start,ind-2,dp);
        int nottake = robHouse(arr,start,ind-1,dp);
        dp[ind] = Math.max(take,nottake);
        return dp[ind];
    }
}