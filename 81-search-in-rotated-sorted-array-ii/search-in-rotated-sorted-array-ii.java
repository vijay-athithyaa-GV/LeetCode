class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return true;
            // if the mid & l & r values equals..just trim the l and r
            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                l = l+1;
                r = r-1;
                
            }
            else if(nums[l]<=nums[mid] ){
                if(nums[l]<=target && target<=nums[mid])
                        r = mid-1;
                else
                        l = mid+1;
            }else{
                if(nums[mid]<=target && target<=nums[r])
                        l = mid+1;
                else
                        r = mid-1;
            }
        }
        return false;
    }
}