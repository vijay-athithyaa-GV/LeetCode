class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int maxlen = 0;
        int len = 0;
        while(j<nums.length){
            if(nums[j]==1){
                len++;
                maxlen = Math.max(maxlen,len);
            }else{
                len=0;
            }
            j++;
        }       
        return maxlen; 
    }
}