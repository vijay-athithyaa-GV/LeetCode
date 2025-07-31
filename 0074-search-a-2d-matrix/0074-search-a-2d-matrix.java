class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        return binary(matrix,0,(n*m)-1,target);
    }
    public boolean binary(int[][] arr,int l,int r,int tar){
        int m = arr[0].length;
        int i = l/m;
        int j = l%m;
        while(l<=r){
            int mid = (l+r)/2;
            i = mid/m;
            j = mid%m;
            if(arr[i][j] == tar)
                return true;
            else if(tar<arr[i][j])
                r = mid-1;
            else 
                l = mid+1;
        }
        return false;
    }
}