class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-2;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == nums[mid^1])
                l = mid+1;
            else
                r = mid-1;
        }
        return nums[l];
    }
}