import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                swap(nums,i,ind);
                break;
            }
        }

        reverse(nums,ind+1,n-1);
    }

    public void swap(int arr[],int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public void reverse(int arr[],int i,int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
}