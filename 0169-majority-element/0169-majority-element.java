class Solution {
    public int majorityElement(int[] nums) {
    int n = nums.length;
    int el=0;
    int count = 0;
    for(int i=0;i<n;i++){
            if(count == 0){
                el = nums[i];
                count = 1;
            }
            else if(el == nums[i]){
                count++;
            }else
                count--;
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(el==nums[i])
                cnt++;
        }
        if(cnt>n/2)
            return el;
        return -1;   
    }
}