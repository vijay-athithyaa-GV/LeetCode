import java.util.*;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007; 
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int count = 0;
        int pow[] = new int[n];
        pow[0] = 1;
        for(int k=1;k<n;k++){
            pow[k] = (pow[k-1]*2)%mod;
        }
        
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                count = (count+pow[j-i])%mod;
                i++;
            }else 
                j--;
        }
        return count;
    }
}