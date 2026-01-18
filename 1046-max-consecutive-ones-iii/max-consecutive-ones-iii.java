class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxlen = 0;
        int l = 0;
        for(int i=0;i<n;i++){
            int len = 0;
            for(int j=i;j<n;j++){
                if(nums[j]!=1){
                    if(l<k) l++;
                    else{
                        l = 0;
                        break;
                    } 
                }
                len++;
            }
            maxlen = Math.max(maxlen,len);  
        }
        return maxlen;
    }
}