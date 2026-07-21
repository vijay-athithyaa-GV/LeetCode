import java.util.*;
// idealogy -> 
//1. perfrom the dip check from n-1 -> 0
//2. swap the dip ind with the next highest element ind;
//3. perfrom the reversing for 



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
            Arrays.sort(nums);
            return;
        }
        for(int i=n-1;i>=ind;i--){
            if(nums[i]>nums[ind]){
                swap(nums,i,ind);
                break;
            }
        }
        reverse(nums,ind+1,n-1);
    }
    public void reverse(int arr[],int l,int r){//using the two points
        while(l<r){
            swap(arr,l,r);
            l++;
            r--;
        }
    }
    public void swap(int arr[],int i,int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}