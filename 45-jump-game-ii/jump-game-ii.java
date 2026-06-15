class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int cov = 0;
        int des = n-1,lastind = 0;
        int totjump = 0;
        if(nums.length == 1) return 0;
        for(int i=0;i<n;i++){
            cov = Math.max(cov,i+nums[i]);
            if(i == lastind){
                lastind = cov;
                totjump++;
                if(cov>=des){
                    return totjump;
                }
            }
            
        }
        return totjump;
    }
}