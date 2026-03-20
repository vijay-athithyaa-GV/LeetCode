class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxval = nums[0];
        if(nums.length==1) return nums[0];
        for(int i=0;i<n;i++){
            int mul = 1;
            for(int j=i;j<n;j++){
                mul *= nums[j];
                if(mul>maxval) maxval = mul;
            }
        }
        return maxval;
    }
}