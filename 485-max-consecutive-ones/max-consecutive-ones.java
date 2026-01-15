class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int maxlen = 0;
        int len = 0;
        while(j<nums.length){
            if(nums[j]==1){
                len=len+1;
                maxlen = Math.max(maxlen,len);
            }else{
                len=0;
            }
            j=j+1;
        }       
        return maxlen; 
    }
}