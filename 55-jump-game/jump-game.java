class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int finalpos = n-1;
        int ind = n-2;

        for(int i=ind;i>=0;i--){
            if(i+nums[i]>=finalpos) finalpos = i;
        }
        return finalpos == 0;
    }
}