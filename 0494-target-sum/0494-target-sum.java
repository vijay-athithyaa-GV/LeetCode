class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums,target);
    }
    public int subset(int[] nums,int ind,int tar,int dp[][]){
        if(ind == 0){
        if(tar == 0 && nums[0] == 0)
            return 2;
        if(nums[0] == tar || tar == 0)
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
    int countPartitions(int[] arr, int d) {
        int totsum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)
            totsum+=arr[i];
        if(totsum - d < 0 || (totsum-d)%2!=0) return 0;
        return perfectSum(arr,(totsum-d)/2);  
    }
     public int perfectSum(int[] nums, int target) {
       int n = nums.length;
       int dp[][] = new int[n][target+1];
       for(int i=0;i<n;i++){
           Arrays.fill(dp[i],-1);
       }
       return subset(nums,n-1,target,dp);
    }
}