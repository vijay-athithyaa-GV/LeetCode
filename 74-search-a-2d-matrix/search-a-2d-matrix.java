import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res[] = new int[m*n];
        int k = 0;
        for(int i=0;i<m;i++){
            for(int x:matrix[i]){
                res[k] = x;
                k++;
            }
        }        
        int l = 0;
        int r = (m*n)-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(res[mid] == target){
                return true;
            }else if(target<res[mid]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}