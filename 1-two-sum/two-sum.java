import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        int n = nums.length;
        int flag = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    flag = 1;
                }
            }
            if(flag == 1) break;
        }
        return res;
    }
}