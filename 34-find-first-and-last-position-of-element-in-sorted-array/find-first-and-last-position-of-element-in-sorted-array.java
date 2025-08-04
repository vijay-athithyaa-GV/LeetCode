class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binary(nums,target,true);
        int right = binary(nums,target,false);
        return new int[]{left,right};
    }
    public int binary(int[] arr,int target,boolean first){
        int l = 0;
        int r = arr.length-1;
        int ind = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(target>arr[mid]){
                l = mid+1;
            }else if(target<arr[mid]){
                r = mid-1;
            }
            else{   
                ind = mid;
                if(first)
                    r = mid-1;
                else 
                    l = mid+1;
            }
        }
        return ind;
    }
}