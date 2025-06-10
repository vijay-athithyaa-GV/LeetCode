class Solution {
    public int maxSubArray(int[] nums) {
       int res=MaxSubarray(nums,0,nums.length-1);
       return res;
    }
    public static int MaxSubarray(int arr[],int left,int right){
        if(left==right)
          return arr[left];
        int mid=(left+right)/2;
        
        int leftmax=MaxSubarray(arr,left,mid);
        int rightmax=MaxSubarray(arr,mid+1,right);
        int cross=MaxCross(arr,left,mid,right);
        
        return Math.max(leftmax,Math.max(rightmax,cross));
    }
    public static int MaxCross(int arr[],int left,int mid,int right){
        int sum=0;
        int leftsum=Integer.MIN_VALUE;
        for(int i=mid;i>=left;i--){
            sum+=arr[i];
            leftsum=Math.max(sum,leftsum);
        }
        sum=0;
        int rightsum=Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++){
            sum+=arr[i];
            rightsum=Math.max(sum,rightsum);
        }
        return leftsum+rightsum;
    }
}