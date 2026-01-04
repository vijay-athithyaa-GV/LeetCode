class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int i = 1;
        int n = nums.length;
        for(int j=1;j<n;j++){
            if(nums[i-1] == nums[j] && cnt<=1){
                nums[i] = nums[j];
                cnt++;
                i++;
            }
            else if(nums[i-1]!=nums[j]){
                nums[i++] = nums[j];
                cnt = 1;
            }
        }
        return i;
    }
}