class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totsum=0;
        for(int i=0;i<n;i++){
            totsum+=nums[i];
        }
        if(totsum%2==0)
        {
            int sum = totsum/2;
            return isSubsetSum(nums,sum);
        }else
            return false;
    }
    public boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],false);
        }
        //base case..
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(arr[0]<=sum)
            dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int tar=1;tar<=sum;tar++){
                boolean notTake = dp[i-1][tar];
                boolean take = false;
                if(arr[i]<=tar)
                    take = dp[i-1][tar-arr[i]];
                dp[i][tar] = take || notTake;
            }
        }
        return dp[n-1][sum];
    }
}