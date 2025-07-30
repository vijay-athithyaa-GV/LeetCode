import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int res = 0;
        int fg = 0;
        int arr[] = new int[n];
        Arrays.fill(arr,0);
        for(int i=0;i<n;i++){
            arr[nums[i]]++;
        }
        for(int i=1;i<n;i++){
            if(arr[i]>1){
                res = i;
                break;
            }
        }
        return res;
    }
}