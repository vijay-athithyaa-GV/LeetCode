class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
           if(matrix[i][0]<=target && target<=matrix[i][m-1]){
                return binary(matrix[i],target);
           }
        } 
        return false;
    }
    public boolean binary(int[] arr,int tar){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] == tar)
                return true;
            else if(tar<arr[mid])
                r = mid-1;
            else 
                l = mid+1;
        }
        return false;
    }
}