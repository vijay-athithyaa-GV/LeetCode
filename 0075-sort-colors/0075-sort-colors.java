import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        countSort(nums,res);
        for(int i=0;i<n;i++){
            nums[i] = res[i];
        }
    }
    public void countSort(int[] arr,int[] res){
        int max=arr[0];
        int n = arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]>max)
                max = arr[i];
        }
        int count[] = new int[max+1];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int i=1;i<count.length;i++)
            count[i] = count[i-1]+count[i];
        for(int i=n-1;i>=0;i--){
            res[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
    }
}