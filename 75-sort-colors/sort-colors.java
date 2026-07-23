class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int mid = 0;

        while(mid <= h){
            if(nums[mid] == 0){
                Swap(nums,mid,l);
                mid++;
                l++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                Swap(nums,h,mid);
                h--;
            }
        }

    }

    public void Swap(int arr[],int i,int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}