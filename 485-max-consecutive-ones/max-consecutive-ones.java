class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxcnt = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 1)
                count++;
            else if(nums[i] == 0){
                maxcnt = Math.max(maxcnt,count);
                count = 0;
            }
            maxcnt = Math.max(maxcnt,count);
        }
        return maxcnt;
    }
}