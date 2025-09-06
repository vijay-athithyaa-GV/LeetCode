class Solution {
    public int findMin(int[] nums) {
    int n = nums.length;
    int l = 0;
    int r = n-1;
    int res = Integer.MAX_VALUE;    
    while(l<=r){
        int mid = (l+r)/2;
        if(nums[l]<=nums[mid]){
            res = Math.min(res,nums[l]);
            l = mid+1;
        }
        else if(nums[mid]<=nums[r]){
            res = Math.min(res,nums[mid]);
            r = mid-1;
        }
    }
    return res;
    }
}